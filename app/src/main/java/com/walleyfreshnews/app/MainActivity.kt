package com.walleyfreshnews.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.walleyfreshnews.app.databinding.ActivityMainBinding
import com.walleyfreshnews.app.wnewsadapter.WalleyTechnoAdapter
import com.walleyfreshnews.app.wnewsdata.Articles
import com.walleyfreshnews.app.wnewsdata.WalleyNewsResponse
import com.walleyfreshnews.app.wnewsscreens.DetailWalley
import com.walleyfreshnews.app.wnewsutils.WalleyRetrofitInstance
import com.walleyfreshnews.app.wnewsutils.WtechnoViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(),WalleyTechnoAdapter.Listener {
    private lateinit var binding: ActivityMainBinding

    private val mainviewModel : WtechnoViewModel by viewModels()
    private lateinit var adapter: WalleyTechnoAdapter
    private val crs = CoroutineScope(Dispatchers.IO + Job())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        kwefwfewef()
        owewefwefwef()
        mainviewModel.listNewsData.observe(this,{
            adapter.submitList(it)
        })
    }


    private fun kwefwfewef() = with(binding){
        adapter = WalleyTechnoAdapter(this@MainActivity)
        rcWalleyTechno.layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false)
        rcWalleyTechno.adapter = adapter

    }

    private fun owewefwefwef() = with(binding){
        crs.launch {
            val data =  WalleyRetrofitInstance.api.getNews()

            data.enqueue(object : Callback<WalleyNewsResponse> {
                override fun onResponse(
                    call: Call<WalleyNewsResponse>,
                    response: Response<WalleyNewsResponse>
                ) {
                    mainviewModel.listNewsData.postValue(response.body()?.articles)
                    progressBar.visibility = View.GONE

                }

                override fun onFailure(call: Call<WalleyNewsResponse>, t: Throwable) {

                }

            })

        }



    }

    override fun onClickItem(item: Articles) {
        startActivity(
            Intent(this,DetailWalley::class.java).putExtra("wdata",item)
        )
    }
}