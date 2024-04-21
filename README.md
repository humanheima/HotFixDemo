###

在 App 的 attachBaseContext 方法中加载补丁文件

```java
override fun attachBaseContext(base: Context?) {
    super.attachBaseContext(base)
    Log.i(TAG, "attachBaseContext: ")
    // TODO: 在这里加载可以生效
    FixDexUtils.loadFixedDex(this, getExternalFilesDir(null))
}
```

补丁文件放在 `/storage/emulated/0/Android/data/com.example.hotfixdemo/files` 目录下面。

修复过的类

```kotlin
package com.example.hotfixdemo

import android.app.Activity
import android.widget.Toast

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
            //throw  IllegalArgumentException("静态方法抛出异常")
            Toast.makeText(activity, "调用修复过的类的静态方法，staticPrintInfo方法", Toast.LENGTH_SHORT).show()
        }
    }

    fun printInfo(activity: Activity) {
        //throw  IllegalArgumentException("实例方法抛出异常")
        Toast.makeText(activity, "调用修复过的类的实例方法，printInfo方法", Toast.LENGTH_SHORT).show()
    }


}
```