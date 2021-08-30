package com.hoony.kr.service

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hoony.kr.service.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    var service_intent : Intent? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            service_intent = Intent(this, ServiceClass1::class.java)
            startService(service_intent)
            finish()
        }

        binding.button2.setOnClickListener {
            stopService(service_intent)
        }

        binding.button3.setOnClickListener {
            service_intent = Intent(this, ServiceClass2::class.java)
            startService(service_intent)
            finish()
        }

        binding.button4.setOnClickListener {
            service_intent = Intent(this, ServiceClass3::class.java)
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(service_intent)
            } else {
                startService(service_intent)
            }
            finish()
        }
    }


}