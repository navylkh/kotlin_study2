package com.hoony.kr.handler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import com.hoony.kr.handler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    var handler : Handler? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            var time = System.currentTimeMillis()
            binding.textView.text = "버튼 클릭 : ${time}"
        }

        /*
        while(true) {
            SystemClock.sleep(100)
            var time = System.currentTimeMillis()
            binding.textView2.text = "while : ${time}"
        }
         */
        handler = Handler()

        var thread = ThreadClass()
        //handler?.post(thread)
        handler?.postDelayed(thread, 100)
    }

    inner class ThreadClass : Thread() {
        override fun run() {
            var time = System.currentTimeMillis()
            binding.textView2.text = "Handler : ${time}"

            //handler?.post(this)
            handler?.postDelayed(this, 100)
        }
    }
}