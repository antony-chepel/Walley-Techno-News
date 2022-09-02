package com.walleyfreshnews.app.wnewsdata

import java.io.Serializable

data class Articles(
    val author : String,
    val title : String,
    val description : String,
    val urlToImage : String,
) : Serializable
