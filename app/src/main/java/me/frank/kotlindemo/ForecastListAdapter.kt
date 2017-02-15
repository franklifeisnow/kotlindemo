package me.frank.kotlindemo

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
/**
 * Created by Lijinpeng on 2017/2/15.
 */
class ForecastListAdapter(val items: List<String>) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>(){
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }


    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}