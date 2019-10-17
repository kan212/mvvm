package com.ihandy.mvvm

import androidx.databinding.ObservableField
import com.ihandy.mvvm.base.BaseViewModel

class MainViewModel : BaseViewModel(){
    var title = ObservableField<String>()
    init {
        title.set("TOOO")
    }
}