package com.example.foregroundserviceexample

import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat

class MyService : Service() {
    override fun onBind(p0: Intent?): IBinder? {
        TODO("Return the communication channel to service")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val ChannelID : String = "Test"
        val ChannelName : String = "Android"

        //download some videos
        val intent : Intent = Intent(this,MainActivity::class.java)
        val pendingIntent : PendingIntent = PendingIntent.getActivity(this,0,intent,0)

        //2 - Building a notification
        val builder : NotificationCompat.Builder = NotificationCompat.Builder(this,ChannelID)
            .setSmallIcon(R.drawable.ic_alarm)
            .setContentTitle("Test Notification")
            .setContentText("This is a testing notification")
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)

        val notification : Notification = builder.build()

        startForeground(123,notification)
        stopForeground(true)

        return super.onStartCommand(intent, flags, startId)
    }

}