package com.example.baselib.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType

/**
 *Author: chinadragon
 *Time: 2024/5/7
 */
abstract class BaseActivity<VM : BaseAndroidViewModel<*>, VDB : ViewDataBinding>(
    private val contentViewResId: Int,
    private val variableId: Int = 0,
) : AppCompatActivity() {
    protected lateinit var mViewModel: VM
    protected lateinit var binding: VDB
    override fun onCreate(savedInstanceState: Bundle?) {
        initBefore(savedInstanceState)
        super.onCreate(savedInstanceState)
        initViewModel()
        initDataBinding()
        initData()
        initView(savedInstanceState)
        loadData()
        initEvent()
    }

    private fun initDataBinding() {
        binding = DataBindingUtil.setContentView(this, contentViewResId)
        if (::binding.isInitialized) {
            binding.apply {
                lifecycleOwner = this@BaseActivity
                setVariable(variableId, mViewModel)
            }
        }
    }

    private fun initViewModel() {

        var type: Class<VM>? = null
        if (this.javaClass.genericSuperclass != null && this.javaClass.genericSuperclass is ParameterizedType) {
            ((this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<VM>).also {
                type = it
            }

        } else if (this.javaClass.superclass != null && this.javaClass.superclass.genericSuperclass != null && this.javaClass.superclass.genericSuperclass is ParameterizedType) {
            type =
                (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<VM>
        }

        type?.let {
            mViewModel = ViewModelProvider(this)[it]
            mViewModel = ViewModelProvider(this)[it]
            if (::mViewModel.isInitialized) {

            }
        }

    }


    open fun initBefore(savedInstanceState: Bundle?) {

    }

    open fun initView(savedInstanceState: Bundle?) {

    }

    /**
     * Called before {@link #initView(savedInstanceState: Bundle?)}
     */
    open fun initData() {

    }

    open fun loadData() {

    }

    open fun initEvent() {

    }
}