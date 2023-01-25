package com.example.contacts_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.EditText
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun saveContact(view:View){
        val txtName = findViewById<EditText>(R.id.txtName)
        val txtPhone = findViewById<EditText>(R.id.txtPhone)
        val txtEmail = findViewById<EditText>(R.id.txtEmail)
        val txtZip = findViewById<EditText>(R.id.txtZip)
        val txtStreet = findViewById<EditText>(R.id.txtStreet)

        val name = txtName.text.toString()
        val phone = txtPhone.text.toString()
        val email = txtEmail.text.toString()
        val zip = txtZip.text.toString()
        val street = txtStreet.text.toString()

        val newContact = contact(name,phone,email,zip,street)

        val intent : Intent = Intent(this,ContactsList::class.java)
        intent.putExtra("contact", newContact)
        startActivity(intent)

    }
}

class contact : Serializable {

    var cName : String = ""
    var cPhone : String = ""
    var cEmail : String = ""
    var cZip : String = ""
    var cStreet : String = ""

    constructor (name: String,phone : String,email : String,zip : String,street : String) {
        cName = name
        cPhone = phone
        cEmail = email
        cZip = zip
        cStreet = street
    }

}