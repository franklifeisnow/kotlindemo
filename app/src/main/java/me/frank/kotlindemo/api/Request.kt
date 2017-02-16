package me.frank.kotlindemo.api

import me.frank.kotlindemo.log.L
import java.net.URL

/**
 * Created by Lijinpeng on 2017/2/16.
 */
public class Request(val url: String){
    public fun run(){
        val forecastJsonStr = URL(url).readText()
        L.d(forecastJsonStr)
    }
}