package com.example.baselib.https

/**
 *Author: chinadragon
 *Time: 2024/5/19
 */
data class ApiResponse<T>(
    val errorMsg: String?,
    val data: T?,
    val errorCode: Int,
    val url: String?
)

data class ApiErrorInfo(
    var errorMsg: String?,
    var errorCode: Int,
    var url: String?
)
