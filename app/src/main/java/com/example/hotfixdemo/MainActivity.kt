package com.example.hotfixdemo

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import pub.devrel.easypermissions.AfterPermissionGranted
import pub.devrel.easypermissions.EasyPermissions


class MainActivity : AppCompatActivity() {

    companion object {
        private val TAG: String = "MainActivity"

        const val RC_READ_WRITE_EXTERNAL = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate: ${getExternalFilesDir(null)?.absolutePath}")
        if (!EasyPermissions.hasPermissions(
                this, Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
        ) {
            EasyPermissions.requestPermissions(
                this,
                "I need permission",
                RC_READ_WRITE_EXTERNAL,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
        }

        btnInvokeInstanceMethod.setOnClickListener {
            val hotFixBugTest = SimpleHotFixBugTest()
            hotFixBugTest.printInfo(this)
        }

        btnInvokeStaticMethod.setOnClickListener {
            SimpleHotFixBugTest.staticPrintInfo(this)
        }

        btnFix.setOnClickListener {
            // TODO: 注意，在这里加载不能立即生效
            FixDexUtils.loadFixedDex(this, getExternalFilesDir(null))

        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    @AfterPermissionGranted(RC_READ_WRITE_EXTERNAL)
    private fun methodRequiresTwoPermission() {
        val perms = arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        if (EasyPermissions.hasPermissions(this, *perms)) {
            Toast.makeText(this, "已获得读写权限", Toast.LENGTH_SHORT)
        } else {
            // Do not have permissions, request them now
            Toast.makeText(this, "can't get permission", Toast.LENGTH_SHORT)

        }
    }
}
