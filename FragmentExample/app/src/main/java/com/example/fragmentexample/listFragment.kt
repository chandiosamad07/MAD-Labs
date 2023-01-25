package com.example.fragmentexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView

class listFragment : Fragment() {

    var array = arrayOf("Windows","Mac","Linux","Ubuntu","Fedora","Unix","ChromeOS")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val listView = view.findViewById<ListView>(R.id.listView)
        val adapter : ArrayAdapter<String> = ArrayAdapter(requireActivity(),android.R.layout.simple_list_item_1,array)
        listView.adapter = adapter

        return view

    }

}