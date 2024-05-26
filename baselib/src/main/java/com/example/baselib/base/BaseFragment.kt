package com.example.baselib.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.example.baselib.utils.GenericsUtil
import java.lang.reflect.ParameterizedType

/**
 *Author: chinadragon
 *Time: 2024/5/18
 */
abstract class BaseFragment<VM : BaseAndroidViewModel<*>, VDB : ViewDataBinding>(private val contentViewResId: Int,
    private val variableId: Int = 0,
) : Fragment() {
    protected lateinit var mViewModel: VM
    protected lateinit var binding: VDB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initViewModel()
        initDataBinding(inflater, container)
        return if (!::binding.isInitialized) inflater.inflate(
            contentViewResId,
            container,
            false
        ) else binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initBefore(savedInstanceState)
        super.onViewCreated(view, savedInstanceState)
        initData()
        initView(savedInstanceState)
        loadData()
        initEvent()
    }

    open fun initBefore(savedInstanceState: Bundle?) {

    }

    private fun initViewModel() {
        var type: Class<VM>? = null
        if (this.javaClass.genericSuperclass != null && this.javaClass.genericSuperclass is ParameterizedType) {
            type =
                (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<VM>

        } else if (this.javaClass.superclass != null && this.javaClass.superclass.genericSuperclass != null && this.javaClass.superclass.genericSuperclass is ParameterizedType) {
            type =
                (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<VM>
        }

        type?.let {
            mViewModel = ViewModelProvider(this)[it]
            if (::mViewModel.isInitialized) {
               //todo
            }
        }
    }

//    private fun initViewModel() {
//        mViewModel = GenericsUtil.getInstant(this)
//    }

    private fun initDataBinding(inflater: LayoutInflater, container: ViewGroup?) {
        binding = DataBindingUtil.inflate(inflater, contentViewResId, container, false)
        if (::binding.isInitialized) {
            binding.apply {
                lifecycleOwner = lifecycleOwner
                setVariable(variableId, mViewModel)
            }
        }
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