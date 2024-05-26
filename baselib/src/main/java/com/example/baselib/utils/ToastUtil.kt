package com.example.baselib.utils

import android.widget.Toast
import com.example.baselib.base.BaseLibSDK

/**
 *Author: chinadragon
 *Time: 2024/5/20
 */

object ToastUtil {
    private var mToast: Toast? = null
    fun cancel() {
        mToast?.let {
            it.cancel()
            mToast = null
        }
    }

    @JvmStatic
    fun show(resId: Int) {
        show(BaseLibSDK.getContext().getString(resId))
    }

    @JvmStatic
    fun show(text: String?) {
        if (text.isNullOrEmpty() || text.isBlank()) {
            return
        }
        cancel()
        mToast = Toast.makeText(BaseLibSDK.getContext(), text, Toast.LENGTH_SHORT)
        mToast?.show()
    }


}