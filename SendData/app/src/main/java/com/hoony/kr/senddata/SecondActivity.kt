package com.hoony.kr.senddata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hoony.kr.senddata.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var data1 = intent.getIntExtra("data1", 0)
        var data2 = intent.getDoubleExtra("data2", 0.0)
        var data3 = intent.getBooleanExtra("data3", false)
        var data4 = intent.getStringExtra("data4")

        binding.textView2.text = "data1 : ${data1}\n"
        binding.textView2.append("data2 : ${data2}\n")
        binding.textView2.append("data3 : ${data3}\n")
        binding.textView2.append("data4 : ${data4}\n")

        binding.button2.setOnClickListener {
            var intent2 = Intent()
            intent2.putExtra("value1", 200)
            intent2.putExtra("value2", 22.22)
            intent2.putExtra("value3", true)
            intent2.putExtra("value4", "문자열2")

            setResult(RESULT_OK, intent2)

            finish()
        }
    }
}