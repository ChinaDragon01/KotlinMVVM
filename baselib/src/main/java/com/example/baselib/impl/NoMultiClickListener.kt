package com.example.baselib.impl

import android.view.View

/**
 *Author: chinadragon
 *Time: 2024/5/19
 */
class NoMultiClickListener(val delay: Int = 1000, val onNoMultiClick: (View) -> Unit) :
    View.OnClickListener {
    private var mLastClickTime = 0L

    override fun onClick(v: View) {
        if (System.currentTimeMillis() - mLastClickTime >= delay) {
            mLastClickTime = System.currentTimeMillis()
            onNoMultiClick(v)
        }
    }

}