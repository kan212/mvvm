package com.ihandy.mvvm.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.ihandy.mvvm.obtainViewModel

abstract class BaseActivity<VB : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {

    val viewModel by lazy {
        obtainViewModel(getBaseViewModel())
    }


    val mBinding: VB by lazy {
        DataBindingUtil.setContentView<VB>(this, getLayoutId())
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding.lifecycleOwner = this
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun getBaseViewModel(): VM
}