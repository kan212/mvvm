package com.ihandy.mvvm

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.ihandy.mvvm.base.BaseModelFactory

fun <T : ViewModel> AppCompatActivity.obtainViewModel(viewModelClass: T) = 
    ViewModelProviders.of(this, BaseModelFactory.getInstance(application)).get(viewModelClass::class.java)

fun <T:ViewModel> Fragment.obtainViewModel(viewModelClass: T) =
    ViewModelProviders.of(this, activity?.application?.let { BaseModelFactory.getInstance(it) }).get(viewModelClass::class.java)

