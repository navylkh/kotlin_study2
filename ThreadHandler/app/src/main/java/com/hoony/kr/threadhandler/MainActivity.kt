package com.hoony.kr.threadhandler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.os.SystemClock
import android.util.Log
import com.hoony.kr.threadhandler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    var isRunning : Boolean = false
    var handler:DisplayHandler? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            var time = System.currentTimeMillis()
            binding.textView.text = "버튼 클릭 : ${time}"
        }

        handler = DisplayHandler()

        isRunning = true
        var thread = ThreadClass()
        thread.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
    }

    inner class ThreadClass : Thread() {
        override fun run() {

            var a1 = 10
            var a2 = 20

            while(isRunning) {
                SystemClock.sleep(100)
                var time = System.currentTimeMillis()
                Log.d("test1", "쓰레드 : ${time}")
                //binding.textView2.text = "쓰레드 : ${time}"
                //handler?.sendEmptyMessage(0)
                /*
                var msg = Message()
                msg.what = 0    // 작업을 나눌 수 있다.
                msg.obj = time
                handler?.sendMessage(msg)
                 */

                var msg2 = Message()
                msg2.what = 1
                msg2.arg1 = ++a1            // int
                msg2.arg2 = ++a2            // int
                msg2.obj = "안녕하세요"       // 객체
                handler?.sendMessage(msg2)
            }
        }
    }

    inner class DisplayHandler : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            //var time = System.currentTimeMillis()
            if( msg?.what == 0) {
                binding.textView2.text = "Handler : ${msg?.obj}"
            } else if(msg?.what == 1) {
                binding.textView2.text = "${msg?.arg1}, ${msg?.arg2}, ${msg?.obj}"
            }

        }
    }
}