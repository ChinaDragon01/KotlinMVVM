package com.example.baselib.constant

import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import java.nio.charset.Charset

/**
 *Author: chinadragon
 *Time: 2024/5/20
 */
object HttpsConstant {
    const val NET_SUCCESS = 0
    const val TIME_OUT_SECONDS = 30L// 请求超时
    const val TOKEN_OVERDUE = 10000401 //token过期
    const val URL_Decode_UTF_8 = "UTF-8"
    const val MEDIA_TYPE_VALUE = "application/json; charset=UTF-8"
    val CONTENT_TYPE: MediaType = MEDIA_TYPE_VALUE.toMediaType()
    val CHARSET: Charset = Charset.forName(URL_Decode_UTF_8)

    // api地址 https://www.wanandroid.com/blog/show/2
    const val BASE_URL = "https://www.wanandroid.com/"
    const val LOGIN = "user/login"
    const val ARTICLE = "article/list/0/json" // 首页文章列表
    const val WX_ARTICLE = "wxarticle/chapters/json"
}