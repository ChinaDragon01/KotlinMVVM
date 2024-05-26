package com.example.baselib.global

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.example.baselib.entity.AppActivityManager

/**
 *Author: chinadragon
 *Time: 2024/5/20
 */
class AppActivityLifecycleCallbacksImpl: Application.ActivityLifecycleCallbacks {
    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        AppActivityManager.INSTANCE.addActivity(activity)

    }

    override fun onActivityStarted(activity: Activity) {
    }

    override fun onActivityResumed(activity: Activity) {
    }

    override fun onActivityPaused(activity: Activity) {
    }

    override fun onActivityStopped(activity: Activity) {
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
    }

    override fun onActivityDestroyed(activity: Activity) {
        AppActivityManager.INSTANCE.finishActivity(activity)

    }
}