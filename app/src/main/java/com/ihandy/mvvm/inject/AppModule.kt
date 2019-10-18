package com.ihandy.mvvm.inject

import com.ihandy.mvvm.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {
    single<HelloRepository> { HelloRepositoryImpl() }
}

val activityModule = module {
    viewModel { SecondViewModule(get()) }
    viewModel { MainViewModel() }
}


val appmodule = listOf(activityModule,dataModule)
