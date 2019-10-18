package com.ihandy.mvvm.inject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ihandy.mvvm.base.BaseViewModel
import kotlin.reflect.KProperty

class SecondViewModule(var repo: HelloRepository) : BaseViewModel() {

    fun meet() = repo.hello()

    var title: MutableLiveData<String>  = MutableLiveData("hh")

    var title2: MutableLiveData<String> = MutableLiveData("hh")


}

