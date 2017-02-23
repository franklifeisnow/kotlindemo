package me.frank.kotlindemo.ui

import android.net.http.SslError
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.view.View
import android.webkit.*
import kotlinx.android.synthetic.main.activity_web.*
import me.frank.kotlindemo.BuildConfig
import me.frank.kotlindemo.R
import java.lang.reflect.Field

class WebActivity : AppCompatActivity() {

//    companion object {
//        val URL = "WebActivity:url"
//    }

    val baseurl = "http://m.jd.com"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        val url = intent.getStringExtra("url")

        val i = if (url == null
                || url.equals("")) baseurl else intent.getStringExtra("url")

        webview.settings.javaScriptEnabled = true//支持javascript

        webview.requestFocus()//触摸焦点起作用

        webview.scrollBarStyle = WebView.SCROLLBARS_OUTSIDE_OVERLAY//取消滚动条

        webview.settings.javaScriptCanOpenWindowsAutomatically = true//设置允许js弹出alert对话框

        webview.loadUrl(i)

        webview.setWebViewClient(MyWebViewClient())

        webview.setWebChromeClient(MyWebChromeClient())
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if ((keyCode == KeyEvent.KEYCODE_BACK) and webview.canGoBack()) {
            webview.goBack()
            return true
        } else {
            this.finish()
        }
        return false
    }

    override fun onResume() {
        webview.settings.javaScriptEnabled = true
        super.onResume()
    }

    override fun onStop() {
        webview.settings.javaScriptEnabled = false
        super.onStop()
    }

    override fun onDestroy() {
        webview.visibility = View.GONE
        releaseAllWebViewCallback()
        super.onDestroy()
    }

    //避免webview内存泄漏
    private fun releaseAllWebViewCallback() {
        if(android.os.Build.VERSION.SDK_INT < 16){
            try {
                var field: Field = webview.javaClass.getDeclaredField("mWebViewCore")
                field = field.type.getDeclaredField("mBrowserFrame")
                field = field.type.getDeclaredField("sConfigCallback")
                field.isAccessible = true
                field.set(null,null)
            }catch ( e : NoSuchFieldException){
                if(BuildConfig.DEBUG){
                    e.printStackTrace()
                }
            }catch ( e: IllegalAccessException){
                if(BuildConfig.DEBUG){
                    e.printStackTrace()
                }
            }
        }else{
            try {
                var sConfigCallback: Field = Class.forName("android.webkit.BrowserFrame").getDeclaredField("sConfigCallback")
                if(sConfigCallback != null){
                    sConfigCallback.isAccessible = true
                    sConfigCallback.set(null, null)
                }
            }catch (e: NoSuchFieldException){
                if(BuildConfig.DEBUG){
                    e.printStackTrace()
                }
            }catch (e: ClassNotFoundException){
                if(BuildConfig.DEBUG){
                    e.printStackTrace()
                }
            }catch (e: IllegalAccessException){
                if(BuildConfig.DEBUG){
                    e.printStackTrace()
                }
            }
        }
    }

    private class MyWebViewClient : WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            view!!.loadUrl(url)
            return true
        }

        //onReceivedSslError为webView处理ssl证书设置
        override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
            super.onReceivedSslError(view, handler, error)
        }
    }

    private class MyWebChromeClient : WebChromeClient() {
        override fun onJsConfirm(view: WebView?, url: String?, message: String?, result: JsResult?): Boolean {
            return super.onJsConfirm(view, url, message, result)
        }

    }
}
