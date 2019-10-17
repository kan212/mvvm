package com.ihandy.mvvm.base

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BaseModelFactory constructor(context: Application) :
    ViewModelProvider.AndroidViewModelFactory(context) {

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

    companion object {
        @Volatile
        private var _instance: BaseModelFactory? = null

        fun getInstance(application: Application): BaseModelFactory =
            _instance ?: synchronized(BaseModelFactory::class.java) {
                    _instance ?: BaseModelFactory(application).also {
                        _instance = it
                    }
            }
    }
}

