package com.ihandy.mvvm.base

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BaseModelFactory(context: Application) : ViewModelProvider.AndroidViewModelFactory(context) {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when (modelClass) {
            is BaseViewModel -> {
                return BaseViewModel() as T
            }
            else -> Exception("not support ViewModel")
        }
        return super.create(modelClass)
    }
}