package com.example.hotfixdemo

import android.app.Activity

/**
 * Created by dumingwei on 2020/9/25.
 *
 * Desc:
 */
class SimpleHotFixBugTest {

    private val TAG: String = "SimpleHotFixBugTest"


    companion object {

        @JvmStatic
        fun staticPrintInfo(activity: Activity) {
            throw  IllegalArgumentException("静态方法抛出异常")
        }
    }

    fun printInfo(activity: Activity) {
        throw  IllegalArgumentException("实例方法抛出异常")
    }

}