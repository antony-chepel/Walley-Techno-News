package com.walleyfreshnews.app.wnewsutils

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.walleyfreshnews.app.wnewsdata.Articles

class WtechnoViewModel : ViewModel() {
    val listNewsData = MutableLiveData<List<Articles>>()
}