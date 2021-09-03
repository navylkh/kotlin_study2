package com.hoony.kr.activitycontroller

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hoony.kr.activitycontroller.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    var input_fragment = InputFragment()
    var result_fragment = ResultFragment()

    var value1 : String? = null
    var value2 : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        setFragment("input")
    }

    fun setFragment(name : String) {
        var tran = supportFragmentManager.beginTransaction()
        when(name) {
            "input" -> {
                tran.replace(R.id.container, input_fragment)
            }
            "result" -> {
                tran.replace(R.id.container, result_fragment)
                tran.addToBackStack(null)
            }
        }
        tran.commit()
    }
}