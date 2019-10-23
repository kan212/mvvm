package com.ihandy.mvvm

import android.os.Bundle
import android.view.View
import com.ihandy.mvvm.base.BaseActivity
import com.ihandy.mvvm.dagger.net.NetService
import com.ihandy.mvvm.databinding.ActivityMainBinding
import com.ihandy.mvvm.rx.asyncSubscribe
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding,MainViewModel>(), View.OnClickListener {

    override fun getBaseViewModel() = MainViewModel()

    override fun getLayoutId(): Int = R.layout.activity_main

    @Inject
    lateinit var netService: NetService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding.model = viewModel
        viewModel.title.set("test for extends")
        mBinding.listener = this
        var result = netService.getArticles(0).asyncSubscribe({
            it.data
        },{
            it.message
        })
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.progressBar -> viewModel.onlick()
        }
    }
}
