package com.example.baselib.base

import android.app.Application

/**
 *Author: chinadragon
 *Time: 2024/2/18 09:36
 */
object BaseLibSDK {
    private lateinit var mContext: Application
    fun init(context: Application) {
        mContext = context
    }

    fun getContext(): Application {
        return mContext
    }
}