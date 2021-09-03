package com.example.testlistfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testlistfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var list_fragment = TestListFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var tran = supportFragmentManager.beginTransaction()
        tran.replace(R.id.container, list_fragment)
        tran.commit()
    }
}