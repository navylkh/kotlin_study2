package com.hoony.kr.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hoony.kr.fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    var first = FirstFragment()
    var second = SecondFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button6.setOnClickListener {
            var tran = supportFragmentManager.beginTransaction()
            //tran.add(R.id.container, first)
            tran.replace(R.id.container, first)
            tran.addToBackStack(null)
            tran.commit()
        }

        binding.button7.setOnClickListener {
            var tran = supportFragmentManager.beginTransaction()
            //tran.add(R.id.container, second)
            tran.replace(R.id.container, second)
            tran.addToBackStack(null)
            tran.commit()
        }
    }
}