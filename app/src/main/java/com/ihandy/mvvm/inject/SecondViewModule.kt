package com.ihandy.mvvm.inject

import androidx.lifecycle.MutableLiveData
import com.ihandy.mvvm.base.BaseViewModel

class SecondViewModule(var repo: HelloRepository) : BaseViewModel() {

    fun meet() = repo.hello()

    var title: MutableLiveData<String> = MutableLiveData("hh")


}