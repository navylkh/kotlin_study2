package com.hoony.kr.onactivityresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hoony.kr.onactivityresult.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    val SECOND_ACTIVITY = 1
    val THIRD_ACTIVITY = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button2.setOnClickListener {
            var intent = Intent(this, SecondActivity::class.java)
            //startActivity(intent)
            startActivityForResult(intent, SECOND_ACTIVITY)

        }

        binding.button4.setOnClickListener {
            var intent = Intent(this, ThirdActivity::class.java)
            startActivityForResult(intent, THIRD_ACTIVITY)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode) {
            SECOND_ACTIVITY -> {
                binding.textView2.text = "Second Activity에서 돌아옴\n"
                when (resultCode) {
                    Activity.RESULT_OK ->
                        binding.textView2.append("RESULT_OK")
                    Activity.RESULT_CANCELED ->
                        binding.textView2.append("RESULT_CANCELED")
                    Activity.RESULT_FIRST_USER ->
                        binding.textView2.append("RESULT_FIRST_USER")
                }
            }
            THIRD_ACTIVITY ->
                binding.textView2.text = "Third Activity에서 돌아옴\n"
        }

    }
}