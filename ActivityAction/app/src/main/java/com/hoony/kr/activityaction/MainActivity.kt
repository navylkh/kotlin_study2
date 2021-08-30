package com.hoony.kr.activityaction

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hoony.kr.activityaction.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    var permission_list = arrayOf(
        Manifest.permission.CALL_PHONE
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        checkPermission()

        binding.button.setOnClickListener {
            var uri = Uri.parse("geo:37.243243,131.861601")
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        binding.button2.setOnClickListener {
            var uri = Uri.parse("http://developer.android.com")
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        binding.button3.setOnClickListener {
            var uri = Uri.parse("tel:0000000000")
            var intent = Intent(Intent.ACTION_DIAL, uri)
            startActivity(intent)
        }

        binding.button4.setOnClickListener {
            var uri = Uri.parse("tel:00000000000")
            var intent = Intent(Intent.ACTION_CALL, uri)
            startActivity(intent)
        }
    }

    fun checkPermission() {
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return
        }

        for(permission : String in permission_list) {
            var chk = checkCallingOrSelfPermission(permission)

            if(chk == PackageManager.PERMISSION_DENIED) {
                requestPermissions(permission_list, 0)
                break
            }
        }
    }
}