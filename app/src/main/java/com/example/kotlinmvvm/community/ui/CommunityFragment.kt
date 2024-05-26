package com.example.kotlinmvvm.community.ui

import com.example.baselib.base.BaseFragment
import com.example.kotlinmvvm.BR
import com.example.kotlinmvvm.R
import com.example.kotlinmvvm.community.model.CommunityViewModel
import com.example.kotlinmvvm.databinding.FragmentCommunityBinding

/**
 *Author: chinadragon
 *Time: 2024/5/20
 */
class CommunityFragment : BaseFragment<CommunityViewModel, FragmentCommunityBinding>(
    R.layout.fragment_community,
    BR.mCommunityViewModel
) {

    override fun initData() {
        super.initData()
    }

}