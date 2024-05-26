package com.example.baselib.entity

import android.app.Activity
import com.example.baselib.utils.LogUtil
import java.util.*

/**
 *Author: chinadragon
 *Time: 2024/5/18
 */
class AppActivityManager {

    private val activityStack: Stack<Activity> = Stack<Activity>()

    fun addActivity(activity: Activity?) {
        activity?.let {
            activityStack.add(it)
        }
    }

    fun finishActivity(activity: Activity?) {

        activity?.let {
            activityStack.remove(it)
            if (!it.isFinishing) {
                it.finish()
            }
        }
    }

    fun removeActivity(activity: Activity) {
        activityStack.remove(activity)
    }

    fun finishAllActivity() {
        activityStack.forEach { it?.finish() }
        activityStack.clear()
    }

    fun finishAllButThis(cls: Class<*>) {
        finishAllButThis(cls.name)
    }

    fun finishAllButThis(clsName: String) {
        val it: MutableIterator<Activity> = activityStack.iterator()
        while (it.hasNext()) {
            val mActivity = it.next()
            if (mActivity.javaClass.name != clsName) {
                mActivity.finish()
                it.remove()
            }
        }
    }

    fun finishActivity(clsName: String) {
        val it: MutableIterator<Activity> = activityStack.iterator()
        while (it.hasNext()) {
            val mActivity = it.next()
            if (mActivity.javaClass.name == clsName) {
                mActivity.finish()
                it.remove()
            }
        }
    }

    fun topActivity(): Activity? {
        if (activityStack.isEmpty()) {
            return null
        }

        try {
            var activity: Activity = activityStack.peek()
            while (activity.isFinishing || activity.isDestroyed) {
                activityStack.pop()
                activity = activityStack.peek()
            }
            return activity
        } catch (e: Exception) {
            LogUtil.i(TAG, "topActivity e：$e")
        }

        return null

    }

    companion object {
        const val TAG = "AppActivityManager"
        val INSTANCE by lazy { AppActivityManager() }
    }
}