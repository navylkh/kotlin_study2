package com.hoony.kr.asynctask

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import com.hoony.kr.asynctask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            var time = System.currentTimeMillis()
            binding.textView.text = "버튼 클릭 : ${time}"
        }

        var sync = AsyncTaskClass()
        sync.execute(10,20)
    }

    inner class AsyncTaskClass : AsyncTask<Int, Long, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
            binding.textView2.text = "AsyncTask 가동"
        }

        override fun doInBackground(vararg params: Int?): String {
            var a1 = params[0]!! // !! null을 허용하지 않는 변수에 집어넣을 때
            var a2 = params[1]!!

            for(idx in 0..9) {
                SystemClock.sleep(1000)

                a1++
                a2++

                Log.d("test1", "${idx} : ${a1}, ${a2}")
                //binding.textView2.text = "${idx} : ${a1}, ${a2}"

                var time = System.currentTimeMillis()
                publishProgress(time)
            }

            return "수행이 완료되었습니다"
        }

        override fun onProgressUpdate(vararg values: Long?) {
            super.onProgressUpdate(*values)

            binding.textView2.text = "Async : ${values[0]}"
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            binding.textView2.text = result
        }
    }
}