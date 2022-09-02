package com.walleyfreshnews.app.wnewsdata

data class WalleyNewsResponse(
    val status : String,
    val totalResults : String,
    val articles : List<Articles>

)
