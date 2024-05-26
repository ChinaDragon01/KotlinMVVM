package com.example.baselib.utils

import com.example.baselib.constant.GlobalConstant

import android.content.Context
import android.content.SharedPreferences
import com.example.baselib.base.BaseLibSDK


/**
 *Author: chinadragon
 *Time: 2024/5/20
 */
object SharedPreferencesUtil {
    val preferences: SharedPreferences by lazy {
        BaseLibSDK.getContext()
            .getSharedPreferences(GlobalConstant.APP_NAME + "PrefData", Context.MODE_PRIVATE)
    }

    @JvmStatic
    fun put(key: String, value: Any?) {
        val editor = preferences.edit()
        when (value) {
            is String -> editor.putString(key, value)
            is Boolean -> editor.putBoolean(key, value)
            is Int -> editor.putInt(key, value)
            is Float -> editor.putFloat(key, value)
            is Long -> editor.putLong(key, value)
            else -> {
                if (value == null) {
                    editor.putString(key, value)

                } else {
                    editor.putString(key, value.toString())
                }
            }

        }

        editor.apply()
    }

    @JvmStatic
    fun getString(key: String, defValue: String? = null): String? {
        return preferences.getString(key, defValue)
    }

    @JvmStatic
    fun getBoolean(key: String, defValue: Boolean = false): Boolean {
        return preferences.getBoolean(key, defValue)
    }

    @JvmStatic
    fun remove(key: String) {
        preferences.edit().remove(key).apply()
    }


}