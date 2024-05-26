package com.example.kotlinmvc.main.respository

import com.example.baselib.base.BaseRepository
import com.example.baselib.bean.UserInfoBean
import com.example.baselib.bean.WXArticleBean
import com.example.baselib.https.ApiResponse

/**
 *Author: chinadragon
 *Time: 2024/5/25
 */
class LoginRepository : BaseRepository() {

    suspend fun login(parm: Map<String, Any>): ApiResponse<UserInfoBean?> {
        return apiCall { apiService.login(parm) }
    }

}