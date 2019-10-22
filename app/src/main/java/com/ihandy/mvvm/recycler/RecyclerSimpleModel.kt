package com.ihandy.mvvm.recycler

import androidx.lifecycle.ViewModel
import com.ihandy.mvvm.base.BaseViewModel

class RecyclerSimpleModel :BaseViewModel(){

    var data : MutableList<String> = arrayOf("1","2","3","1","2","3","1","2","3","1","2","3").toMutableList()

}