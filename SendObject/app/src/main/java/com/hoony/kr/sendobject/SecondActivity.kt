package com.hoony.kr.sendobject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hoony.kr.sendobject.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var t1 = intent.getParcelableExtra<TestClass>("test1")
        binding.textView2.text =  "t1.data10 : ${t1!!.data10}\n"
        binding.textView2.append("t1.data20 : ${t1?.data20} \n")

        binding.button2.setOnClickListener {
            var t2 = TestClass()
            t2.data10 = 200
            t2.data20 = "문자열2"

            var intent2 = Intent()
            intent2.putExtra("test2", t2)
            setResult(RESULT_OK, intent2)
            finish()
        }
    }
}