package com.example.kotlinmvvm.main.model

import android.app.Application
import android.view.View
import androidx.databinding.Observable
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.MutableLiveData
import com.example.baselib.base.BaseAndroidViewModel
import com.example.baselib.bean.UserInfoBean
import com.example.baselib.impl.NoMultiClickListener
import com.example.baselib.utils.ToastUtil
import com.example.kotlinmvc.main.respository.LoginRepository
import com.example.kotlinmvvm.R

/**
 *Author: chinadragonz
 *Time: 2024/5/19
 */
class LoginViewModel(application: Application) :
    BaseAndroidViewModel<LoginRepository>(application) {
    var pwd = ObservableField<String>()
    var username = ObservableField<String>()
    val btnLoginEnable = ObservableBoolean(false)
    var btnLoginEnabletBackgroundResId = ObservableInt(getColor(R.color.color_aaa))
    val loginLiveData = MutableLiveData<UserInfoBean>()

    private val observableCallBack: Observable.OnPropertyChangedCallback =
        object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                setLoginBtnEnable()
            }
        }

    init {
        pwd.addOnPropertyChangedCallback(observableCallBack)
        username.addOnPropertyChangedCallback(observableCallBack)
    }

    private fun setLoginBtnEnable() {
        val userName = username.get()
        val pwd = pwd.get()
        if (userName.isNullOrBlank() || pwd.isNullOrBlank()) {
            btnLoginEnable.set(false)
            btnLoginEnabletBackgroundResId.set(getColor(R.color.color_aaa))
            return
        }
        btnLoginEnable.set(true)
        btnLoginEnabletBackgroundResId.set(getColor(R.color.black))
    }

    fun loginClick(view: View) {
        view.setOnClickListener(NoMultiClickListener {
            val userName = username.get()
            val pwd = pwd.get()
            if (userName.isNullOrBlank() || pwd.isNullOrBlank()) {
                ToastUtil.show(getString(R.string.login_error_tip))
                return@NoMultiClickListener
            }
            login(userName, pwd)
        })
    }

    fun login(username: String, pwd: String) {
        val map = mapOf("username" to username, "password" to pwd)
        launchApiCall({ repository.login(map) }, {
            if (it.data == null) {
                return@launchApiCall
            }
            loginLiveData.postValue(it.data)
        }, {
            loginLiveData.value = null
        })
    }
}