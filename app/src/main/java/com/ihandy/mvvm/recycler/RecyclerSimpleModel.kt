package com.ihandy.mvvm.recycler

import com.ihandy.mvvm.base.BaseViewModel
import javax.inject.Inject

class RecyclerSimpleModel : BaseViewModel() {

    @Inject
    lateinit var recyclerRepository: RecyclerRepository

    var data: MutableList<String> =
        arrayOf("1", "2", "3", "1", "2", "3", "1", "2", "3", "1", "2", "3").toMutableList()


}