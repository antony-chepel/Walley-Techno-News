package com.walleyfreshnews.app.wnewsapi

import com.walleyfreshnews.app.wnewsdata.WalleyNewsResponse
import retrofit2.Call
import retrofit2.http.GET

interface Wapi {

    @GET("top-headlines?sources=techcrunch&apiKey=848d53bb52fa4bc38d62e0e17896a461")
    fun getNews() : Call<WalleyNewsResponse>
}