package com.hoony.kr.brapp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hoony.kr.brapp2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            //var intent = Intent()
            //intent.setClassName("com.hoony.kr.brapp1", "com.hoony.kr.brapp1.TestReceiver")
            var intent = Intent("com.test.brapp1")
            intent.putExtra("data1", 100)
            intent.putExtra("data2", 11.11)
            sendBroadcast(intent)
        }
    }
}