package com.ihandy.mvvm

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ihandy.mvvm.base.BaseActivity
import com.ihandy.mvvm.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding,MainViewModel>(), View.OnClickListener {


    override fun getBaseViewModel() = MainViewModel()

    override fun getLayoutId(): Int = R.layout.activity_main

    val recyclerView = RecyclerView(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding.model = viewModel
        viewModel.title.set("test for extends")
        mBinding.listener = this
        recyclerView.adapter
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.progressBar -> viewModel.onlick()
        }
    }
}
