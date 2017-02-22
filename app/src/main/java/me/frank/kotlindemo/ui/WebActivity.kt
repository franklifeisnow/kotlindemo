package me.frank.kotlindemo.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web.*
import me.frank.kotlindemo.R

class WebActivity : AppCompatActivity() {

//    companion object {
//        val URL = "WebActivity:url"
//    }

    var url = "https://item.m.jd.com"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

//        val i = if(intent.getStringExtra("url")) else url

        webview.settings.javaScriptEnabled

        webview.loadUrl(url)

        webview.setWebViewClient(MyWebViewClient())
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if ((keyCode == KeyEvent.KEYCODE_BACK) and webview.canGoBack()){
            webview.goBack()
            return true
        }else{
            this.finish()
        }
        return false
    }

    private class MyWebViewClient: WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            view!!.loadUrl(url)
            return true
        }
    }
}
