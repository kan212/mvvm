package com.ihandy.mvvm;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class Test2 extends Activity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        innerView = findViewById(R.id.inner);
    }
}
