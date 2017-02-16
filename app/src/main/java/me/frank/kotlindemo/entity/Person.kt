package me.frank.kotlindemo.entity

/**
 * Created by Lijinpeng on 2017/2/16.
 */
class Person {
    var uid: Int = 0
        get() = field + 10
        set(value) {
            field = value + 100
        }
    var name: String = ""
        get() = field.toUpperCase()
        set(value) {
            field = "Name: $value"
        }

}