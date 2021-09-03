package com.hoony.kr.resource

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.hoony.kr.resource.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding :  ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
//            var str1 = resources.getString(R.string.str2)
//            binding.textView.text = str1
            binding.textView.setText(R.string.str2)
        }

        binding.button2.setOnClickListener {
            binding.textView.text = ""
            var str_array = resources.getStringArray(R.array.data_array)
            for(str1 : String in str_array)
                binding.textView.append("$str1\n")
        }

        binding.button3.setOnClickListener {
            //binding.textView.setTextColor(Color.YELLOW)
            //var color = Color.rgb(26, 106, 129)
            //var color = Color.argb(50, 26, 106, 129)
            var color = ContextCompat.getColor(this, R.color.color1)
            binding.textView.setTextColor(color)
        }

        binding.button4.setOnClickListener {
            var px = resources.getDimension(R.dimen.px)
            var dp = resources.getDimension(R.dimen.dp)
            var sp = resources.getDimension(R.dimen.sp)
            var inch = resources.getDimension(R.dimen.inch)
            var mm = resources.getDimension(R.dimen.mm)
            var pt = resources.getDimension(R.dimen.pt)

            binding.textView.text = "px : ${px}\n"
            binding.textView.append("dp : ${dp}\n")
            binding.textView.append("sp : ${sp}\n")
            binding.textView.append("inch : ${inch}\n")
            binding.textView.append("mm : ${mm}\n")
            binding.textView.append("pt : ${pt}\n")

            binding.textView.setTextSize(20 * dp)
        }
    }
}