package com.example.contacts_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class ContactsList : AppCompatActivity() {

    var contacts = arrayListOf<contact>()
    var contactNames = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts_list)

        var listView : ListView = findViewById(R.id.listView)

        val intent = getIntent()
        val newCon : contact = intent.getSerializableExtra("contact") as contact
        contactNames.add(newCon.cName)

        var adapter : ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1, contactNames)
        listView.adapter = adapter


    }

}