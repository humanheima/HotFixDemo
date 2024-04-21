package com.example.hotfixdemo

import android.app.Application
import android.content.Context
import android.util.Log

class App : Application() {


    private val TAG = "App"

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        Log.i(TAG, "attachBaseContext: ")
        // TODO: 在这里加载可以生效
        FixDexUtils.loadFixedDex(this, getExternalFilesDir(null))
    }


    override fun onCreate() {
        super.onCreate()
        Log.i(TAG, "onCreate: ")

    }

}