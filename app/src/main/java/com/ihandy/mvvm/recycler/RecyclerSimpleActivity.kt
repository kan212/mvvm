package com.ihandy.mvvm.recycler

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ihandy.mvvm.R
import com.ihandy.mvvm.base.BaseActivity
import com.ihandy.mvvm.databinding.ActivityRecyclerSimpleBinding

class RecyclerSimpleActivity : BaseActivity<ActivityRecyclerSimpleBinding, RecyclerSimpleModel>() {
    override fun getBaseViewModel() = RecyclerSimpleModel()

    override fun getLayoutId(): Int = R.layout.activity_recycler_simple

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        mBinding.model = viewModel

        var adapter = SimpleAdapter<ViewDataBinding>( arrayOf("1","2","3","1","2","3","1","2","3","1","2","3").toMutableList())

        mBinding.recyclerView.adapter = adapter
        mBinding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}