package com.hoony.kr.brapp1

import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hoony.kr.brapp1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    var brapp1:TestReceiver? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        addReceiver()

        binding.button.setOnClickListener {
            var intent = Intent(this, TestReceiver::class.java)
            sendBroadcast(intent)
        }
    }

    fun addReceiver() {
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            return
        }

        brapp1 = TestReceiver()
        var filter = IntentFilter("com.test.brapp1")
        registerReceiver(brapp1, filter)
    }

    override fun onDestroy() {
        super.onDestroy()
        if(brapp1 != null) {
            unregisterReceiver(brapp1)
            brapp1 = null
        }
    }
}