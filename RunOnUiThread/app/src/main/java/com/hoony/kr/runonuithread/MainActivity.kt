package com.hoony.kr.runonuithread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import com.hoony.kr.runonuithread.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    var isRunning : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            var time = System.currentTimeMillis()
            binding.textView.text = "버튼 클릭 : ${time}"
        }

        isRunning = true
        var thread = ThreadClass()
        thread.start()
    }

    inner class ThreadClass : Thread() {
        override fun run() {
            while(isRunning) {
                SystemClock.sleep(100)
                var time = System.currentTimeMillis()
                Log.d("test1", "쓰레드 : ${time}")

                runOnUiThread {
                    binding.textView2.text = "쓰레드 : ${time}"
                }
            }
        }
    }
}