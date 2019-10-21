package com.ihandy.mvvm

import androidx.databinding.Observable
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ihandy.mvvm.base.BaseViewModel

class MainViewModel : BaseViewModel() {

    var title = ObservableField<String>()
    init {
        title.set("TOOO")
    }
    private val _likes =  MutableLiveData(1)

    var likes: LiveData<Int> = _likes

    fun onlick(){
        _likes.value = 12
    }
}