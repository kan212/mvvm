package com.ihandy.mvvm.dagger.net

data class HttpResponse<T>(
    var data: T?,
    var errorCode: Int,
    var errorMsg: String?
)