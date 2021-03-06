package com.hoony.kr.osreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.telephony.SmsMessage
import android.widget.Toast

class TestReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.

        when(intent.action) {
            //"android.intent.action.BOOT_COMPLETED" -> {
            Intent.ACTION_BOOT_COMPLETED -> {

                var t1 = Toast.makeText(context, "λΆνμλ£", Toast.LENGTH_SHORT)
                t1.show()
            }
            //"android.provider.Telephony.SMS_RECEIVED" -> {
            Telephony.Sms.Intents.SMS_RECEIVED_ACTION -> {
                var str = ""
                var bundle = intent.extras
                if(bundle != null) {
                    var obj = bundle.get("pdus") as Array<Any>
                    var msg = arrayOfNulls<SmsMessage>(obj.size)

                    for(i in obj.indices) {
                        msg[i] = SmsMessage.createFromPdu(obj[i] as ByteArray)
                    }

                    for(i in msg.indices) {
                        str = msg[i]?.originatingAddress + " : " + msg[i]?.messageBody
                        var t2 = Toast.makeText(context, str, Toast.LENGTH_SHORT)
                        t2.show()
                    }
                }
            }
        }
    }
}