package com.example.hotfixdemo

/**
 * Created by dumingwei on 2020/9/25.
 *
 * Desc:
 */
class SimpleHotFixBugTest {

    private val TAG: String = "SimpleHotFixBugTest"


    companion object {

        @JvmStatic
        fun staticPrintInfo() {
            throw  IllegalArgumentException("静态方法抛出异常")
        }
    }

    fun printInfo() {
        throw  IllegalArgumentException("实例方法抛出异常")
    }

}