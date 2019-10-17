package com.ihandy.mvvm.inject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ihandy.mvvm.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class SecondActivity : AppCompatActivity(){

    val viewModule : SecondViewModule by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}