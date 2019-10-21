package com.ihandy.mvvm

import androidx.databinding.Observable
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ihandy.mvvm.base.BaseViewModel

class MainViewModel : BaseViewModel() ,Observable{

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    var title = ObservableField<String>()
    init {
        title.set("TOOO")
    }
    private val _likes =  MutableLiveData(1)

    var likes: LiveData<Int> = _likes

}