package com.hoony.kr.activityapp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hoony.kr.activityapp2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var data1 = intent.getIntExtra("data1", 0)
        var data2 = intent.getDoubleExtra("data2", 0.0)
        binding.textView.text = "data1 : ${data1}\n"
        binding.textView.append("data2 : ${data2}")

        binding.button.setOnClickListener {
            var intent2 = Intent()
            intent2.putExtra("value1", 200)
            intent2.putExtra("value2", 22.22)
            setResult(RESULT_OK, intent2)
            finish()
        }
    }


}