package com.hoony.kr.osreceiver

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hoony.kr.osreceiver.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var permission_list = arrayOf(
        Manifest.permission.READ_PHONE_STATE,
        Manifest.permission.RECEIVE_SMS
    )
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        checkPermission()
    }

    fun checkPermission() {
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return
        }

        for(permission : String in permission_list) {
            var chk = checkCallingOrSelfPermission(permission)

            if(chk == PackageManager.PERMISSION_DENIED) {
                requestPermissions(permission_list, 0)
                break;
            }
        }
    }
}