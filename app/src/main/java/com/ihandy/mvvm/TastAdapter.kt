package com.ihandy.mvvm

import android.content.Context
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LiveData
import com.ihandy.mvvm.base.BaseActivity
import com.ihandy.mvvm.base.BaseAdapter

class TastAdapter(context: Context) : BaseAdapter<ArrayList<LiveData<*>>, ViewDataBinding>(context) {
    override fun onBindItem(t: ArrayList<LiveData<*>>, binding: ViewDataBinding) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLayoutId(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}