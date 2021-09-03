package com.hoony.kr.orientation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hoony.kr.orientation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if(savedInstanceState != null) {
            binding.textView.text = savedInstanceState.getString("data1")
        }

        binding.button.setOnClickListener {
            binding.textView.text = binding.editTextTextPersonName.text
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState?.putString("data1", binding.textView.text.toString())
    }
}