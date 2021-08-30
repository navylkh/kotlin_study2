package com.hoony.kr.activityapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hoony.kr.activityapp1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    val SECOND_ACTIVITY = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            var intent = Intent("com.test.second")

            intent.putExtra("data1", 100)
            intent.putExtra("data2", 11.11)

            startActivityForResult(intent, SECOND_ACTIVITY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == RESULT_OK) {
            var value1 = data?.getIntExtra("value1", 0)
            var value2 = data?.getDoubleExtra("value2", 0.0)
            binding.textView2.text = "value1 : ${value1}\n"
            binding.textView2.append("value2 : ${value2}")
        }
    }
}