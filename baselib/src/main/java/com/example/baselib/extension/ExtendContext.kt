package com.example.baselib.extension

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

/**
 *Author: chinadragon
 *Time: 2024/2/18 09:54
 */


fun FragmentActivity.countDown(
    timeMillis: Long = 1000,//默认时间间隔 1 秒
    time: Int = 3,//默认时间为 3 秒
    start: (scop: CoroutineScope) -> Unit,
    end: () -> Unit,
    next: (time: Int) -> Unit,
    error: (msg: String?) -> Unit
) {
    lifecycleScope.launch {
        flow {
            (time downTo 1).forEach {
                delay(timeMillis)
                emit(it)
            }
        }.onStart {
            start(this@launch)
        }.onCompletion {
            end()
        }.catch {
            error(it.message ?: "countDown 出现未知错误")
        }.collect {
            next(it)
        }
    }
}