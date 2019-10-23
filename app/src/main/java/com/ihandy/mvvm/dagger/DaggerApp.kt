package com.ihandy.mvvm.dagger

import android.app.Application
import android.content.Context
import com.ihandy.mvvm.dagger.module.RetrofitModule
import dagger.android.*
import javax.inject.Inject

class DaggerApp : Application(), HasAndroidInjector {

    //这里目前看是要用lateinit，不然编译文件会成为private,导致编译错误
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): DispatchingAndroidInjector<Any>? = dispatchingAndroidInjector

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        DaggerAppComponent.create().inject(this)
    }

    override fun onCreate() {
        super.onCreate()
//        DaggerAppComponent.create().inject(this)
    }

}