package com.example.kotlinmvvm.app

import android.app.Application
import com.example.baselib.base.BaseLibSDK
import com.example.baselib.global.AppActivityLifecycleCallbacksImpl

/**
 *Author: chinadragon
 *Time: 2024/2/18 10:15
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(AppActivityLifecycleCallbacksImpl())
        BaseLibSDK.init(this)
    }
}