package com.hoony.kr.xmlclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hoony.kr.xmlclient.databinding.ActivityMainBinding
import org.w3c.dom.Document
import org.w3c.dom.Element
import java.net.URL
import javax.xml.parsers.DocumentBuilderFactory

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
            try {
                var site = "http://192.168.1.127:8080/HttpNetwork_server/xml.jsp"
                var url = URL(site)
                var conn = url.openConnection()
                var input = conn.getInputStream()

                var factory = DocumentBuilderFactory.newInstance()
                var builder = factory.newDocumentBuilder()
                var doc = builder.parse(input)

                var root = doc.documentElement

                var item_node_list = root.getElementsByTagName("item")
                for(i in 0 until item_node_list.length) {
                    var item_element = item_node_list.item(i) as Element

                    var data1_node_list = item_element.getElementsByTagName("data1")
                    var data2_node_list = item_element.getElementsByTagName("data2")
                    var data3_node_list = item_element.getElementsByTagName("data3")

                    var data1_node = data1_node_list.item(0)
                    var data2_node = data2_node_list.item(0)
                    var data3_node = data3_node_list.item(0)

                    var data1 = data1_node.textContent
                    var data2 = data2_node.textContent
                    var data3 = data3_node.textContent

                    runOnUiThread {
                        binding.textView.append("data1 : ${data1}\n")
                        binding.textView.append("data2 : ${data2}\n")
                        binding.textView.append("data3 : ${data3}\n\n")
                    }

                }

            } catch (e : Exception) {
                e.printStackTrace()
            }
        }
    }
}