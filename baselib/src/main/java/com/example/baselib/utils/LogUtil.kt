package com.example.baselib.utils

import android.util.Log
import com.example.baselib.constant.GlobalConstant.PRINGT_LOG

/**
 *Author: chinadragon
 *Time: 2024/2/18 09:48
 */
object LogUtil {
    fun i(text: String?) {
        i(text)
    }

    fun i(tag: String = "==", text: String?) {
        if (text.isNullOrEmpty()) {
            return
        }
        if (PRINGT_LOG) {
            Log.i(tag, text)
        }
    }
}