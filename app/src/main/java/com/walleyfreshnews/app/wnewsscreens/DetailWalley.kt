package com.walleyfreshnews.app.wnewsscreens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.walleyfreshnews.app.databinding.ActivityDetailWalleyBinding
import com.walleyfreshnews.app.wnewsdata.Articles
import java.lang.Exception

class DetailWalley : AppCompatActivity() {
    private lateinit var binding : ActivityDetailWalleyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailWalleyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }


    private fun init() = with(binding){
        val itemData = intent.getSerializableExtra("wdata") as Articles
        titleW.text = itemData.title
        descW.text = itemData.description
        tvAuthor.text = itemData.author
        Picasso.get().load(itemData.urlToImage).into(mainImage,object :
            Callback {
            override fun onSuccess() {
                pbBar.visibility = View.GONE
            }

            override fun onError(e: Exception?) {

            }

        })
        imBackW.setOnClickListener {
            finish()
        }
    }
}