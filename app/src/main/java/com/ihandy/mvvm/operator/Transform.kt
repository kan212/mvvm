package com.ihandy.mvvm.operator

import androidx.arch.core.util.Function
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import kotlin.math.absoluteValue

class Transform {

    private val pageSize = MutableLiveData<Int>()
    private val page = Transformations.map(pageSize) {
        it.absoluteValue
    }
//    var list = Transformations.switchMap(page, Function {  })

}