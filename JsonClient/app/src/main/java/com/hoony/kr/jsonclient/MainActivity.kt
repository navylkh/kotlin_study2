package com.hoony.kr.jsonclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hoony.kr.jsonclient.databinding.ActivityMainBinding
import org.json.JSONArray
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

        binding.textView.text = ""
        binding.button.setOnClickListener {
            var thread = NetworkThread()
            thread.start()
        }
    }

    inner class NetworkThread : Thread() {
        override fun run() {
            var site = "http://192.168.1.127:8080/HttpNetwork_server/json.jsp"
            var url = URL(site)
            var conn = url.openConnection()
            var input = conn.getInputStream()
            var isr = InputStreamReader(input)
            var br = BufferedReader(isr)

            var str:String? = null
            var buf = StringBuffer()

            do {
                str = br.readLine()
                if(str != null) {
                    buf.append(str)
                }
            } while(str != null)

            var root = JSONArray(buf.toString())

            for(i in 0 until root.length()) {
                var obj = root.getJSONObject(i)

                var data1 = obj.getString("data1")
                var data2 = obj.getInt("data2")
                var data3 = obj.getDouble("data3")

                runOnUiThread {
                    binding.textView.append("data1 : ${data1}\n")
                    binding.textView.append("data2 : ${data2}\n")
                    binding.textView.append("data3 : ${data3}\n\n")
                }
            }
        }
    }
}