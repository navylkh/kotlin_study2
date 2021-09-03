package com.hoony.kr.contentprovider

import android.content.ContentValues
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hoony.kr.contentprovider.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            var uri = Uri.parse("content://kr.co.hoony.dbprovider")

            var c = contentResolver.query(uri, null, null, null, null)

            binding.textView.text = ""

            while(c?.moveToNext()!!) {
                var idx_pos = c.getColumnIndex("idx")
                var textData_pos = c.getColumnIndex("textData")
                var intData_pos = c.getColumnIndex("intData")
                var floatData_pos = c.getColumnIndex("floatData")
                var dateData_pos = c.getColumnIndex("dateData")

                var idx = c.getInt(idx_pos)
                var textData = c.getString(textData_pos)
                var intData = c.getInt(intData_pos)
                var floatData = c.getFloat(floatData_pos)
                var dateData = c.getString(dateData_pos)

                binding.textView.append("idx : ${idx}\n")
                binding.textView.append("textData : ${textData}\n")
                binding.textView.append("intData : ${intData}\n")
                binding.textView.append("floatData : ${floatData}\n")
                binding.textView.append("dateData : ${dateData}\n\n")
            }
        }

        binding.button2.setOnClickListener {

            var sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            var date = sdf.format(Date())

            var cv1 = ContentValues()
            cv1.put("textData", "문자열3")
            cv1.put("intData", 300)
            cv1.put("floatData", 33.33)
            cv1.put("dateData", date)

            var cv2 = ContentValues()
            cv2.put("textData", "문자열4")
            cv2.put("intData", 400)
            cv2.put("floatData", 44.44)
            cv2.put("dateData", date)

            var uri = Uri.parse("content://kr.co.hoony.dbprovider")
            contentResolver.insert(uri, cv1)
            contentResolver.insert(uri, cv2)

            binding.textView.text ="저장완료"
        }

        binding.button3.setOnClickListener {
            var cv = ContentValues()
            cv.put("textData", "문자열100")
            var where = "idx=?"
            var args = arrayOf("3")

            var uri = Uri.parse("content://kr.co.hoony.dbprovider")
            contentResolver.update(uri, cv, where, args)

            binding.textView.text = "수정완료"
        }

        binding.button4.setOnClickListener {
            var where = "idx=?"
            var args = arrayOf("1")

            var uri = Uri.parse("content://kr.co.hoony.dbprovider")
            contentResolver.delete(uri, where, args)

            binding.textView.text = "삭제완료"
        }


    }
}