package com.example.alarmmanagerexample

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun setAlarm(view: View){
        //1-
        val alarmManager : AlarmManager =
            getSystemService(ALARM_SERVICE) as AlarmManager

        //2-
        val intent : Intent =
           Intent(this, MainActivity::class.java)
        val pIntent =
            PendingIntent.getActivity(
                this,
                0,
                intent,
                PendingIntent.FLAG_CANCEL_CURRENT)
        //3-
        alarmManager.set(AlarmManager.RTC_WAKEUP,
            System.currentTimeMillis()+5000,
            pIntent)

    }
}