package com.example.kotlinmvvm.home.ui

import androidx.activity.viewModels
import com.example.baselib.base.BaseActivity
import com.example.kotlinmvvm.BR
import com.example.kotlinmvvm.R
import com.example.kotlinmvvm.databinding.ActivityWxarticleBinding
import com.example.kotlinmvvm.home.model.WXArticleViewModel

/**
 *Author: chinadragon
 *Time: 2024/5/25
 */
class WXArticleActivity : BaseActivity<WXArticleViewModel, ActivityWxarticleBinding>(
    R.layout.activity_wxarticle,
    BR.mWXArticleViewModel
) {
    override fun loadData() {
        super.loadData()
        mViewModel.wxArticle()
    }

    override fun initEvent() {
        super.initEvent()
        binding.swipeRefresh.isRefreshing = false
        binding.swipeRefresh.setOnRefreshListener {
            loadData()
        }

        mViewModel.wxArticleLiveData.observe(this) {
            binding.swipeRefresh.isRefreshing = false
        }
    }
}