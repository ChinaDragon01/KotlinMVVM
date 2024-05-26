package com.example.baselib.adapter

import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter

/**
 *Author: chinadragon
 *Time: 2024/5/26
 */
class BaseBindingAdapter {
    @BindingAdapter("backgroundResId")
    fun setbackgroundResId(viewGroup: ViewGroup, @DrawableRes resId: Int) {
        if (resId != 0) {
            viewGroup.setBackgroundResource(resId)
        } else {
            viewGroup.background = null
        }
    }

    @BindingAdapter("android:backgroundColor")
    fun setBackgroundColor(view: View, color: Int) {
        if (color == 0) {
            view.background = null
        } else {
            view.setBackgroundColor(color)
        }
    }
}