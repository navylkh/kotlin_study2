package com.hoony.kr.onactivityresult

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hoony.kr.onactivityresult.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding : ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button3.setOnClickListener {
            finish()
        }
    }
}