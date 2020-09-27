###

补丁文件放在`/storage/emulated/0/Android/data/com.example.hotfixdemo/files`目录下面

```kotlin
package com.example.hotfixdemo

import android.util.Log

/**
 * Created by dumingwei on 2020/9/25.
 *
 * Desc:
 */
class SimpleHotFixBugTest {


    companion object {

        const val TAG: String = "SimpleHotFixBugTest"

        @JvmStatic
        fun staticPrintInfo() {
            //throw  IllegalArgumentException("静态方法抛出异常")
            Log.d(TAG, "staticPrintInfo: ")
        }
    }

    fun printInfo() {
        //throw  IllegalArgumentException("实例方法抛出异常")
        Log.d(TAG, "printInfo: ")
    }

}
```