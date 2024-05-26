package com.example.baselib.utils

import com.google.gson.Gson
import com.google.gson.GsonBuilder

/**
 *Author: chinadragon
 *Time: 2024/5/20
 */
object GsonUtil {
    val gson: Gson =
        GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").disableHtmlEscaping().create()

    fun <T> toObject(jsonString: String, cls: Class<T>): T {
        return gson.fromJson(jsonString, cls)
    }

    fun toJson(any: Any): String {
        return gson.toJson(any)
    }

}