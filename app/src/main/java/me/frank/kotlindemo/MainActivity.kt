package me.frank.kotlindemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
    }
}
