package me.frank.kotlindemo.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_forecast.view.*
import me.frank.kotlindemo.R
import me.frank.kotlindemo.entity.Forecast

/**
 * Created by Lijinpeng on 2017/2/15.
 */
class ForecastListAdapter(val items: List<Forecast>, val itemClick: (Forecast) -> Unit) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>(){
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }


//    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
    class ViewHolder(view: View, val itemClick: (Forecast) -> Unit) : RecyclerView.ViewHolder(view){

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                itemView.textView.text = name

                itemView.setOnClickListener { itemClick(this) }
            }
        }



    }

}