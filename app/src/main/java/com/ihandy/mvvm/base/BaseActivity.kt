package com.ihandy.mvvm.base

import android.content.Context
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.ihandy.mvvm.obtainViewModel
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector

abstract class BaseActivity<VB : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {

    val viewModel by lazy {
        obtainViewModel(getBaseViewModel())
    }


    val mBinding by lazy {
        DataBindingUtil.setContentView<VB>(this, getLayoutId())
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        mBinding.lifecycleOwner = this
    }


    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun getBaseViewModel(): VM
}