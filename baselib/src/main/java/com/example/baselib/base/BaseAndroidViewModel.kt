package com.example.baselib.base

import android.app.Application
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.baselib.constant.HttpsConstant
import com.example.baselib.https.ApiResponse
import com.example.baselib.utils.GenericsUtil
import com.example.baselib.utils.ToastUtil
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 *Author: chinadragon
 *Time: 2024/5/25
 */
open class BaseAndroidViewModel<Repository : BaseRepository>(application: Application) :
    AndroidViewModel(application) {

    open fun getColor(@ColorRes resId: Int): Int {
        return getApplication<Application>().getColor(resId)
    }

    open fun getString(@StringRes resId: Int): String? {
        return getApplication<Application>().getString(resId)
    }

    protected val jobList = mutableListOf<Job>()

    val repository: Repository by lazy {
        return@lazy GenericsUtil.getInstant(this)
    }

    fun <T> launchApiCall(
        apiCall: suspend CoroutineScope.() -> ApiResponse<T>,
        successCallBack: suspend CoroutineScope.(response: ApiResponse<T>) -> Unit = {},
        errorCallBack: suspend CoroutineScope.(response: ApiResponse<T>) -> Unit = {},
        exceptionCallBack: suspend CoroutineScope.() -> Unit = {},
        showToast: Boolean = true,
    ) {
        val job = viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = apiCall()
                withContext(Dispatchers.Main) {
                    if (response.errorCode == HttpsConstant.NET_SUCCESS) {
                        successCallBack(response)

                    } else {
                        errorCallBack(response)
                        if (showToast) {
                            ToastUtil.show(response.errorMsg)
                        }
                    }
                }

            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    exceptionCallBack()
                }
            }
        }

        if (job.isActive) {
            jobList.add(job)
        }
    }

    //演示使用rxjava3
    protected var listDisposable: MutableList<Disposable> = mutableListOf()
    protected open fun addDisposable(disposable: Disposable) {
        listDisposable.add(disposable)
    }

    //演示使用rxjava3
    protected open fun <T> wrapObservable(observable: Observable<ApiResponse<T?>>): Observable<ApiResponse<T?>> {
        return observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .unsubscribeOn(Schedulers.io())
    }

    private fun cancelAllJob() {

        if (listDisposable.isNotEmpty()) {
            listDisposable.forEach {
                if (!it.isDisposed) {
                    it.dispose()
                }
            }
            listDisposable.clear()
        }

        if (jobList.isEmpty()) {
            return
        }

        jobList.forEach {
            if (it.isActive) {
                it.cancel()
            }
        }
        jobList.clear()
    }

    override fun onCleared() {
        cancelAllJob()
        super.onCleared()
    }
}