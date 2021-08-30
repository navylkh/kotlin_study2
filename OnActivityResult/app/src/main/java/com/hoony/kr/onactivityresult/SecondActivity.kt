package com.hoony.kr.onactivityresult

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hoony.kr.onactivityresult.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            finish()
        }

        binding.button5.setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }

        binding.button6.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }

        binding.button7.setOnClickListener {
            setResult(RESULT_FIRST_USER)
            finish()
        }
    }
}