## kotlin 学习demo

学习文档[kotlin-for-android-developers-zh](https://github.com/wangjiegulu/kotlin-for-android-developers-zh/)

### project配置

主buile.gradle中如下示例：

    <span class="hljs-keyword">buildscript</span> {
           ext.support_version = <span class="hljs-string">'23.3.0'</span>
        ext.kotlin_version = <span class="hljs-string">'1.0.0'</span>
        ext.anko_version = <span class="hljs-string">'0.9.1'</span>
        <span class="hljs-keyword">repositories</span> {
            jcenter()
        }
        <span class="hljs-keyword">dependencies</span> {
            <span class="hljs-keyword">classpath</span> <span class="hljs-string">'com.android.tools.build:gradle:2.2.3'</span>
            <span class="hljs-keyword">classpath</span> <span class="hljs-string">"org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"</span>
        }
    }
    `</pre>

    app buidle.gradle中如下示例：

    <pre>`apply plugin: <span class="hljs-string">'com.android.application'</span>
    apply plugin: <span class="hljs-string">'kotlin-android'</span>
    apply plugin: <span class="hljs-string">'kotlin-android-extensions'</span>
       <span class="hljs-keyword">...</span>
    dependencies {
       <span class="hljs-keyword">...</span>
        compile <span class="hljs-string">"org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"</span>
        compile <span class="hljs-string">"org.jetbrains.anko:anko-common:$anko_version"</span>

    }
    buildscript {
        repositories{
            jcenter()
        }
        dependencies{
            classpath <span class="hljs-string">"org.jetbrains.kotlin:kotlin-android-extensions:$kotlin_version"</span>
        }
    }

### startActivity

> startActivity(Intent(MainActivity@ this, ListActivity::class.java))