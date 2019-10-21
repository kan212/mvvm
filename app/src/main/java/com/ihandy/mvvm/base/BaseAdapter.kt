package com.ihandy.mvvm.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView


abstract class BaseAdapter<T, VB : ViewDataBinding> constructor(private val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var item: ArrayList<T>

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var vb = DataBindingUtil.getBinding<VB>(holder.itemView)
        vb?.let { onBindItem(item[position], it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            DataBindingUtil.inflate<VB>(LayoutInflater.from(context), getLayoutId(), parent, false)
        return BaseViewHolder(binding.root)
    }


    override fun getItemCount(): Int = item.size

    abstract fun getLayoutId(): Int

    abstract fun onBindItem(t: T, binding: VB)

    class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
