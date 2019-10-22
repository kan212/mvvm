package com.ihandy.mvvm.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<VB : ViewDataBinding> :
    RecyclerView.Adapter<BaseAdapter.DataBindingViewHolder<VB>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindingViewHolder<VB> =
        DataBindingViewHolder(
            LayoutInflater.from(parent.context).inflate(
                getLayoutId(viewType),
                parent,
                false
            )
        )

    abstract fun getLayoutId(viewType: Int): Int
    abstract fun bindingData(dataBinding: VB, position: Int)

    override fun onBindViewHolder(holder: DataBindingViewHolder<VB>, position: Int) {
        var dataBinding = holder.dataBinding
        bindingData(dataBinding, position)
    }


    class DataBindingViewHolder<T : ViewDataBinding>(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val dataBinding: T = DataBindingUtil.bind<T>(itemView)!!
    }

}