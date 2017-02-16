package me.frank.kotlindemo.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import me.frank.kotlindemo.R
import me.frank.kotlindemo.adapter.ForecastListAdapter
import me.frank.kotlindemo.api.Request
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.find
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread

class ListActivity : AppCompatActivity() {

    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

//        val foracastList = findViewById(R.id.forecast_list) as RecyclerView
        val foracastList: RecyclerView = find(R.id.forecast_list) // use anko
        foracastList.layoutManager = LinearLayoutManager(this)
        foracastList.adapter = ForecastListAdapter(items)

        async() {
            val url = "http://192.168.2.129:5638/hello"
            Request(url).run()
            uiThread { longToast("Request performed") }
        }
    }
}
