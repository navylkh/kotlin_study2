package com.hoony.kr.socketclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hoony.kr.socketclient.databinding.ActivityMainBinding
import java.io.DataInputStream
import java.io.DataOutputStream
import java.net.Socket

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            var thread = NetworkTread()
            thread.start()
        }
    }

    inner class NetworkTread : Thread() {
        override fun run() {
            try {
                var socket = Socket("192.168.1.127", 55555)

                var input = socket.getInputStream()
                var dis = DataInputStream(input)

                var output = socket.getOutputStream()
                var dos = DataOutputStream(output)

                var data1 = dis.readInt()
                var data2 = dis.readDouble()
                var data3 = dis.readUTF()

                dos.writeInt(200)
                dos.writeDouble(22.22)
                dos.writeUTF("클라이언트가 보낸 문자열")

                socket.close()

                runOnUiThread {
                    binding.textView.text = "data1 : ${data1}\n"
                    binding.textView.append("data2 : ${data2}\n")
                    binding.textView.append("data3 : ${data3}")
                }
            } catch (e : Exception) {
                e.printStackTrace()
            }
        }
    }
}