package com.example.kotlinmvvm.main.adpater


import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 *Author: chinadragon
 *Time: 2024/5/20
 */
internal class MainPageAdapter(
    @NonNull fragmentActivity: FragmentActivity,
    val pages: List<Fragment> = emptyList()
) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return pages.size
    }

    override fun createFragment(position: Int): Fragment {
        return pages.get(position)
    }

}