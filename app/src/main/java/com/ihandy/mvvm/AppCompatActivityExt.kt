package com.ihandy.mvvm

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.ihandy.mvvm.base.BaseModelFactory

fun <T : ViewModel> AppCompatActivity.obtainViewModel(viewModelClass: T) = 
    ViewModelProviders.of(this, BaseModelFactory.getInstance(application)).get(viewModelClass::class.java)



