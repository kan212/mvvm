package com.ihandy.mvvm.dagger.net

import com.ihandy.mvvm.MainActivity
import com.ihandy.mvvm.dagger.annation.ActivityScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Named
import javax.inject.Scope


@Module
abstract class ActivityModule {
    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity
}