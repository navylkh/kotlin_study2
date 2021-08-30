package com.hoony.kr.permission

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hoony.kr.permission.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    var permission_list = arrayOf(
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.READ_CONTACTS,
        Manifest.permission.WRITE_CONTACTS,
        Manifest.permission.SEND_SMS,
        Manifest.permission.RECEIVE_SMS
    )

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

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        binding.textView.text = ""

        var idx = 0
        for(idx in grantResults.indices) {
            if(grantResults[idx] == PackageManager.PERMISSION_GRANTED) {
                binding.textView.append("${permission_list[idx]} : 허용함\n")
            } else {
                binding.textView.append("${permission_list[idx]} : 허용하지 않음\n")
            }
        }
    }
}