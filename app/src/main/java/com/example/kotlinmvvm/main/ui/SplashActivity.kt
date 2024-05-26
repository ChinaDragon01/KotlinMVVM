package com.example.kotlinmvvm.main.ui

import android.content.Intent
import com.example.baselib.base.BaseActivity
import com.example.baselib.extension.countDown
import com.example.baselib.utils.LogUtil
import com.example.kotlinmvvm.BR
import com.example.kotlinmvvm.R
import com.example.kotlinmvvm.databinding.ActivitySplashBinding
import com.example.kotlinmvvm.main.model.SplashViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel

/**
 *Author: chinadragon
 *Time: 2024/5/20
 */
class SplashActivity :
    BaseActivity<SplashViewModel, ActivitySplashBinding>(R.layout.activity_splash,BR.mSplashViewModel) {
    private var mCountDownJob: CoroutineScope? = null
    override fun initData() {
        super.initData()
        val second3 = 3
        this.countDown(time = second3, start = {
            binding.tvCountDown.setText("剩余 $second3 秒")
            mCountDownJob = it
        }, end = {
            LogUtil.i("SplashActivity", "倒计时结束了")
            //正式项目里需要判断用户是否已登录 TODO
            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            finish()

        }, next = {
            LogUtil.i("SplashActivity", "剩余 $it 秒")
            binding.tvCountDown.setText("剩余 ${it - 1} 秒")

        }, error = {

        })
    }

    override fun onDestroy() {
        mCountDownJob?.let {
            it.cancel()
        }
        super.onDestroy()
    }
}