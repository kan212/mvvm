package com.ihandy.mvvm

import android.app.Application
import android.content.Context
import com.ihandy.mvvm.base.BaseModelFactory
import com.ihandy.mvvm.inject.appmodule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application(){


    override fun onCreate() {
        super.onCreate()
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