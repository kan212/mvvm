package com.ihandy.mvvm.dagger

import com.ihandy.mvvm.dagger.module.RetrofitModule
import com.ihandy.mvvm.dagger.net.ActivityModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class,AndroidInjectionModule::class,ActivityModule::class])
interface AppComponent:AndroidInjector<DaggerApp>{

}