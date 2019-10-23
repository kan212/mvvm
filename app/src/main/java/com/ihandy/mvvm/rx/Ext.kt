package com.ihandy.mvvm.rx

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

fun <T> Observable<T>.async(): Observable<T> {
    return this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}

fun <T> Observable<T>.asyncSubscribe(onNext: (T) -> Unit, onError: (Throwable) -> Unit) {
    this.async()
        .subscribe(object : Observer<T>{
            override fun onComplete() {
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: T) {
                onNext(t)
            }

            override fun onError(e: Throwable) {
                onError(e)
            }

        })
}