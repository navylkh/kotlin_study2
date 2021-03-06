package com.hoony.kr.service

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.os.SystemClock
import android.util.Log

// TODO: Rename actions, choose action names that describe tasks that this
// IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
private const val ACTION_FOO = "com.hoony.kr.service.action.FOO"
private const val ACTION_BAZ = "com.hoony.kr.service.action.BAZ"

// TODO: Rename parameters
private const val EXTRA_PARAM1 = "com.hoony.kr.service.extra.PARAM1"
private const val EXTRA_PARAM2 = "com.hoony.kr.service.extra.PARAM2"
/**
 * An [IntentService] subclass for handling asynchronous task requests in
 * a service on a separate handler thread.

 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.

 */
class ServiceClass2 : IntentService("ServiceClass2") {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }

    // 별도의 스레드로 실행됨.
    override fun onHandleIntent(intent: Intent?) {
        var idx = 0
        while( idx < 10 ) {
            SystemClock.sleep(1000)
            var time = System.currentTimeMillis()
            Log.d("test1", "Intent Service Running : ${time}")

            idx++
        }
    }

}