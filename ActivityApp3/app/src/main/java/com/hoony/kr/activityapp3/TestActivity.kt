package com.hoony.kr.activityapp3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hoony.kr.activityapp3.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {
    private lateinit var binding : ActivityTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(R.layout.activity_test)
    }
}