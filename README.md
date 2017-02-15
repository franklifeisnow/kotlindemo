## kotlin 学习demo

学习文档[kotlin-for-android-developers-zh](https://github.com/wangjiegulu/kotlin-for-android-developers-zh/)

### project配置

主buile.gradle中如下示例：

    buildscript {
    ext.support_version = '23.3.0'
    ext.kotlin_version = '1.0.0'
    ext.anko_version = '0.9.1'
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:2.2.3'
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"

    }
	}


app buidle.gradle中如下示例：

    apply plugin: 'com.android.application'
	apply plugin: 'kotlin-android'
	apply plugin: 'kotlin-android-extensions'

	...

	dependencies {
	...
    compile "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
    compile "org.jetbrains.anko:anko-common:$anko_version"
	}
	buildscript {
    repositories{
        jcenter()
    }
    dependencies{
        classpath "org.jetbrains.kotlin:kotlin-android-extensions:$kotlin_version"
    }
	}

### startActivity

> startActivity(Intent(MainActivity@ this, ListActivity::class.java))