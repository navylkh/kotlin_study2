package com.hoony.kr.httpnetwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hoony.kr.httpnetwork.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            var thread = NetworkThread()
            thread.start()
        }
    }

    inner class NetworkThread : Thread() {
        override fun run() {
            //var site = "http://www.google.com"
            var site = "http://192.168.1.127:8080/HttpNetwork_server/string.jsp"
            var url = URL(site)
            var conn = url.openConnection()

            var input = conn.getInputStream()
            var isr = InputStreamReader(input, "UTF-8")
            var br = BufferedReader(isr)

            var str:String? = null
            var buf = StringBuffer()

            do {
                str = br.readLine()
                if(str != null) {
                    buf.append(str)
                }
            } while( str != null )

            var data = buf.toString()

            runOnUiThread {
                binding.textView.text = data
            }
        }
    }
}