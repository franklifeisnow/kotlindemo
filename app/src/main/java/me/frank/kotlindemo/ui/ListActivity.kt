package me.frank.kotlindemo.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import me.frank.kotlindemo.R
import me.frank.kotlindemo.adapter.ForecastListAdapter
import me.frank.kotlindemo.entity.Forecast
import org.jetbrains.anko.find

class ListActivity : AppCompatActivity() {


    private val items = listOf(
            Forecast("img001", "三星", "http://item.m.jd.com/product/1750523.html?sid=f20ecdb983c4e17235cbd3aaf25d034e", 1),
            Forecast("img001", "三星", "", 1),
            Forecast("img001", "三星", "http://www.baidu.com", 1),
            Forecast("img001", "三星", "http://www.baidu.com", 1),
            Forecast("img001", "三星", "http://www.baidu.com", 1),
            Forecast("img001", "三星", "http://www.baidu.com", 1)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

//        val foracastList = findViewById(R.id.forecast_list) as RecyclerView
        val foracastList: RecyclerView = find(R.id.forecast_list) // use anko
        foracastList.layoutManager = LinearLayoutManager(this)
        foracastList.layoutManager = GridLayoutManager(this, 3)
        foracastList.adapter = ForecastListAdapter(items) {
            startActivity(Intent(ListActivity@ this, WebActivity::class.java).putExtra("url",it.url))
        }

//        async() {
//            val url = "http://192.168.2.129:5638/hello"
//            Request(url).run()
//            uiThread {
////                longToast("Request performed")
//
//            }
//        }
    }
}
