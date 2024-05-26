package com.example.kotlinmvvm.main.ui

import android.content.Intent
import com.example.baselib.base.BaseActivity
import com.example.baselib.impl.NoMultiClickListener
import com.example.baselib.utils.ToastUtil
import com.example.kotlinmvvm.BR
import com.example.kotlinmvvm.R
import com.example.kotlinmvvm.databinding.ActivityLoginBinding
import com.example.kotlinmvvm.home.ui.WXArticleActivity
import com.example.kotlinmvvm.main.model.LoginViewModel

/**
 *Author: chinadragon
 *Time: 2024/5/19
 */
class LoginActivity : BaseActivity<LoginViewModel, ActivityLoginBinding>(
    R.layout.activity_login,
    BR.mLoginViewModel
) {

    override fun initEvent() {
        super.initEvent()
        with(binding) {
            btnLookWXArticle.setOnClickListener(NoMultiClickListener {
                startActivity(Intent(this@LoginActivity, WXArticleActivity::class.java))
            })
        }

        mViewModel.loginLiveData.observe(this) {
            if (it == null) {

                return@observe
            }
        }
    }

}