package com.ihandy.mvvm.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.ihandy.mvvm.obtainViewModel

abstract class BaseFragment<VB : ViewDataBinding, VM : BaseViewModel> : Fragment() {

    val viewModel: VM by lazy {
        obtainViewModel(getBaseViewModel())
    }

    val mBinding: VB by lazy {
        DataBindingUtil.inflate<VB>(layoutInflater,getLayoutId(),null,false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding.lifecycleOwner = this
        return mBinding.root
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun getBaseViewModel(): VM
}