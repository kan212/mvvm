package com.ihandy.mvvm

import android.app.Application
import android.content.Context
import com.ihandy.mvvm.base.BaseModelFactory
import com.ihandy.mvvm.inject.appmodule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application(){


    companion object{
        var _context : Application? = null
        val modelFactory = _context?.let { BaseModelFactory(context = it) }
    }

    override fun onCreate() {
        super.onCreate()
        _context = this
        startKoin {
            androidContext(this@App)
            androidLogger()
            modules(appmodule)
        }
    }

    override fun getApplicationContext(): Context {
        return this
    }
}