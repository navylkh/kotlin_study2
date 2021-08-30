package com.hoony.kr.sendobject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hoony.kr.sendobject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    val SECOND_ACTIVITY = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            var t1 = TestClass()
            t1.data10 = 100
            t1.data20 = "문자열!"

            var intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("test1", t1)
            startActivityForResult(intent, SECOND_ACTIVITY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == RESULT_OK) {
            var t2 = data?.getParcelableExtra<TestClass>("test2")
            binding.textView.text = "t2.data10 : ${t2!!.data10}\n"
            binding.textView.append("t2.data20 : ${t2?.data20}")
        }
    }
}