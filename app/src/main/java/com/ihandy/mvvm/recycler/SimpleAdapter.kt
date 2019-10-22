package com.ihandy.mvvm.recycler

import androidx.databinding.ViewDataBinding
import com.ihandy.mvvm.R
import com.ihandy.mvvm.databinding.ItemSimple2Binding
import com.ihandy.mvvm.databinding.ItemSimpleBinding

class SimpleAdapter<VB : ViewDataBinding>(private val items: List<String>) : BaseAdapter<VB>() {

    override fun bindingData(dataBinding: VB, position: Int) {
        when (getItemViewType(position)) {
            0 -> bindingItemData(dataBinding as ItemSimpleBinding, position)
            1 -> bindingItem2Data(dataBinding as ItemSimple2Binding, position)
        }
    }

    override fun getLayoutId(viewType: Int): Int {
        return when (viewType) {
            0 -> R.layout.item_simple
            1 -> R.layout.item_simple2
            else -> R.layout.item_simple2
        }
    }

    override fun getItemCount(): Int = items.size


    override fun getItemViewType(position: Int): Int {
        return when (position % 2) {
            0 -> 0
            1 -> 1
            else -> 2
        }
    }


    private fun bindingItemData(dataBinding: ItemSimpleBinding, position: Int) {
        dataBinding.name = items[position]
    }

    private fun bindingItem2Data(dataBinding: ItemSimple2Binding, position: Int) {
        dataBinding.name = items[position]
    }
}