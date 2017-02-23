package me.frank.kotlindemo.ui

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.format.Formatter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import me.frank.kotlindemo.R
import me.frank.kotlindemo.entity.Person
import me.frank.kotlindemo.log.L

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        L.init(this.javaClass)

//        message.text = "Hello Kotlin!"

//        message.setOnClickListener{
//            startActivity(Intent(MainActivity@ this, ListActivity::class.java))
//        }
//        message.setOnClickListener() {
//            startActivity(Intent(MainActivity@ this, ListActivity::class.java))
//        }
        message.setOnClickListener({
            startActivity(Intent(MainActivity@ this, ListActivity::class.java))
        })

        val am = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

        val availMemStr: String  = getSystemAvailbeMemorySize(am)

        message.text = "可用内存: "+ availMemStr

        test()
//        rxjavaTest()
    }

    private fun rxjavaTest() {
//        Observable.just("one","two","three")
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(/* an Observer */)




    }

    // 获得系统可用内存信息
    private fun  getSystemAvailbeMemorySize(am: ActivityManager): String {
        val memoryInfo: ActivityManager.MemoryInfo = ActivityManager.MemoryInfo()
        am.getMemoryInfo(memoryInfo)
        val memSize: Long = memoryInfo.availMem

        val availMemStr: String = formateFileSize(memSize)

        return availMemStr
    }
    //调用系统函数，字符串转换 long -String KB/MB
    private fun formateFileSize(size: Long): String{
        return Formatter.formatFileSize(MainActivity@ this, size)
    }

    fun test() {
//        val s = "Example"
//        val c = s[2]
//
//        for (c in s){
//            L.d(c.toString())
//            println(c)
//        }

        var person = Person()
        person.name = "frank"
        person.uid = 1
        val name = person.name
        var id = person.uid
        L.d("UID: " + id.toString())
        L.d(name)

//        toast("la la la ", Toast.LENGTH_LONG)



        for (i in 1..9){
            for (j in 1..9){
                println("${i} x ${j} = "+i*j)
            }
        }

    }

    fun Context.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT){
        Toast.makeText(this, message, duration).show()
    }
}
