package com.ihandy.mvvm.direct

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DirectViewModule :ViewModel(){

    var user :String = "hh"

    var live :MutableLiveData<String> = MutableLiveData<String>("init")


    var live2 :MutableLiveData<String> = MutableLiveData<String>()
}