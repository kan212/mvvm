package com.ihandy.mvvm

import android.app.Application

import com.ihandy.mvvm.base.BaseModelFactory

object Test {

    fun getInstance(application: Application): BaseModelFactory {
        return BaseModelFactory(application)
    }
}
