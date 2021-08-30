package com.hoony.kr.ipc

import android.app.ActivityManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import com.hoony.kr.ipc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    var ipc_service : IPCService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var intent = Intent(this, IPCService::class.java)
        if(isServiceRunning("com.hoony.kr.ipc.IPCService") == false) {
            startService(intent)
            // startService()없이 bindService() 만으로 서비스가 시작되면 끝나고 해제를 하면 서비스가 죽음.
        }

        bindService(intent, mConnection, Context.BIND_AUTO_CREATE)

        binding.button.setOnClickListener {
            var value = ipc_service?.getNumber()
            binding.textView.text = "value : ${value}"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(mConnection)
    }

    fun isServiceRunning(name:String) : Boolean {
        var manager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        for (service: ActivityManager.RunningServiceInfo in manager.getRunningServices(Int.MAX_VALUE)) {
            if (service.service.className.equals(name)) {
                return true
            }
        }
        return false
    }

    private val mConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as IPCService.LocalBinder
            ipc_service = binder.getService()
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            TODO("Not yet implemented")
        }
    }

}