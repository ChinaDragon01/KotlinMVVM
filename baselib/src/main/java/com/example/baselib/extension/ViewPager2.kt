package com.example.baselib.extension

import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

fun ViewPager2.initDefeaultUI(
    parmAdapter: FragmentStateAdapter,
    parmOrientation: Int = ViewPager2.ORIENTATION_HORIZONTAL,
    canScroll: Boolean = false
) {
    adapter = parmAdapter
    orientation = parmOrientation
    isUserInputEnabled = canScroll
}

fun ViewPager2.initDefeaultUI(
    parmOrientation: Int = ViewPager2.ORIENTATION_HORIZONTAL,
    canScroll: Boolean = false
) {
    orientation = parmOrientation
    isUserInputEnabled = canScroll
}