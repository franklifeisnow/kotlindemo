package me.frank.kotlindemo.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import me.frank.kotlindemo.R
import me.frank.kotlindemo.log.L

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        L.init(this.javaClass)

        message.text = "Hello Kotlin!"

//        message.setOnClickListener{
//            startActivity(Intent(MainActivity@ this, ListActivity::class.java))
//        }
//        message.setOnClickListener() {
//            startActivity(Intent(MainActivity@ this, ListActivity::class.java))
//        }
        message.setOnClickListener({
            startActivity(Intent(MainActivity@ this, ListActivity::class.java))
        })

        test()
    }

    fun test(){
        val s = "Example"
//        val c = s[2]

        for (c in s){
//            L.d(c.toString())
            println(c)
        }
    }
}
