package com.ihandy.mvvm.inject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.ihandy.mvvm.MainViewModel
import com.ihandy.mvvm.R
import com.ihandy.mvvm.databinding.ActivityMainBinding
import org.koin.android.viewmodel.ext.android.viewModel

class SecondActivity : AppCompatActivity() {

    val viewModule: SecondViewModule by viewModel()
    val mainViewModule: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var b = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        b.secondModel = viewModule
        b.model =mainViewModule
//        mainViewModule.title.set("second")
//        viewModule.title.postValue("hh")
//        viewModule.title2.postValue(viewModule.meet())
    }
}