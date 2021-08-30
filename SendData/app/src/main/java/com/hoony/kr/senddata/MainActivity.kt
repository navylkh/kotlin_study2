package com.hoony.kr.senddata

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hoony.kr.senddata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    val SECOND_ACTIVITY = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            var intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("data1", 100)
            intent.putExtra("data2", 11.11)
            intent.putExtra("data3", true)
            intent.putExtra("data4", "문자열!")

            //startActivity(intent)
            startActivityForResult(intent, SECOND_ACTIVITY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK) {
            var value1 = data?.getIntExtra("value1", 0)
            var value2 = data?.getDoubleExtra("value2", 0.0)
            var value3 = data?.getBooleanExtra("value3", false)
            var value4 = data?.getStringExtra("value4")

            binding.textView.text = "value1 : ${value1}\n"
            binding.textView.append("value2 : ${value2}\n")
            binding.textView.append("value3 : ${value3}\n")
            binding.textView.append("value4 : ${value4}\n")
        }
    }
}