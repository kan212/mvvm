package com.ihandy.mvvm

import android.os.Bundle
import com.ihandy.mvvm.base.BaseActivity
import com.ihandy.mvvm.databinding.ActivityMainBinding
import com.ihandy.mvvm.inject.SecondActivity

class MainActivity : BaseActivity<ActivityMainBinding,MainViewModel>() {

    override fun getBaseViewModel() = MainViewModel()

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding.model = viewModel
        viewModel.title.set("fuck the world")
    }
}
