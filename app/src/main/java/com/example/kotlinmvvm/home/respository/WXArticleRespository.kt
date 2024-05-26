package com.example.kotlinmvvm.home.respository

import com.example.baselib.base.BaseRepository
import com.example.baselib.bean.WXArticleBean
import com.example.baselib.https.ApiResponse
import io.reactivex.rxjava3.core.Observable

/**
 *Author: chinadragon
 *Time: 2024/5/25
 */
class WXArticleRespository : BaseRepository() {
    suspend fun wxArticle(): ApiResponse<List<WXArticleBean>> {
        return apiCall { apiService.wxArticle() }
    }

    //演示使用rxjava3
    fun wxArticle2(): Observable<ApiResponse<List<WXArticleBean>?>> {
        return apiService.wxArticle2()
    }
}