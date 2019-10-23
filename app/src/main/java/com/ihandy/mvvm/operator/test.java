package com.ihandy.mvvm.operator;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

public class test {

    MutableLiveData<Inner> ld = new MutableLiveData<>();

    MutableLiveData td = (MutableLiveData) Transformations.map(ld, new Function<Inner, MutableLiveData<Boolean>>() {
        @Override
        public MutableLiveData<Boolean> apply(Inner input) {
            return ld.getValue().innerld;
        }
    });

    MutableLiveData test = (MutableLiveData) Transformations.switchMap(ld, new Function<Inner, LiveData<Boolean>>() {
        @Override
        public LiveData<Boolean> apply(Inner input) {
            return input.innerld;
        }
    });

    public class Inner {

        public MutableLiveData<Boolean> innerld = new MutableLiveData<>();

    }


}
