package com.ihandy.mvvm.base

import androidx.recyclerview.widget.RecyclerView
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.IFlexible


class FlexAdapter<T : IFlexible<*>>(items: List<T>?) : FlexibleAdapter<T>(items){

}
