package com.example.contentprovider

import android.Manifest.permission.READ_CONTACTS
import android.Manifest.permission.WRITE_CONTACTS
import android.content.pm.PackageManager
import android.database.Cursor
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(ContextCompat.checkSelfPermission(
                this, WRITE_CONTACTS
            ) ==
                PackageManager.PERMISSION_GRANTED) {

            val contactsCursor : Cursor? = contentResolver.query(
                ContactsContract.Contacts.CONTENT_URI,
                arrayOf(ContactsContract.Contacts.DISPLAY_NAME),
                null,
                null,
                null
            )

            contactsCursor!!.moveToFirst()
            Toast.makeText(this,
                "Contact Name: "+contactsCursor.getString(0),
                Toast.LENGTH_LONG)
                .show()

        }
        else{
            requestPermissions(arrayOf(WRITE_CONTACTS, READ_CONTACTS),0)
        }

    }
}
