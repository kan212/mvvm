package com.ihandy.mvvm.inject

import androidx.lifecycle.ViewModel

class SecondViewModule(var repo: HelloRepository) : ViewModel(){

    fun meet() = repo.hello()

}