package com.ihandy.mvvm.dagger.net

import com.ihandy.mvvm.dagger.data.Article
import com.ihandy.mvvm.dagger.data.Page
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface NetService{

    /**
     * 首页文章列表
     */
    @GET("article/list/{pageNo}/json")
    fun getArticles(@Path("pageNo") pageNo: Int): Observable<HttpResponse<Page<Article>>>


}