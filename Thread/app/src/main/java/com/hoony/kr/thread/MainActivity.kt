package com.hoony.kr.thread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import com.hoony.kr.thread.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    var isRunning = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            var now = System.currentTimeMillis()
            binding.textView.text = "버튼 클릭 : ${now}"
        }

        /*
        while(true) {
            var now = System.currentTimeMillis()
            binding.textView2.text = "무란 루프 : ${now}"
        }
         */
        isRunning = true
        var thread = ThreadClass1()
        thread.start()

    }

    inner class ThreadClass1 : Thread() {
        override fun run() {
            while(isRunning) {
                SystemClock.sleep(100)
                var now = System.currentTimeMillis()
                Log.d("test1", "쓰레드 : ${now}")

                binding.textView2.text = "쓰레드 : ${now}"
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning =  false
    }
}