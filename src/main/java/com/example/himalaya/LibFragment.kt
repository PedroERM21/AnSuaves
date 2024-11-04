package com.example.himalaya

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class LibFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_lib, container, false)
        val cultureInfoTextView = view.findViewById<TextView>(R.id.cultureInfoTextView)
        val button = view.findViewById<Button>(R.id.buttonToRegion)

        cultureInfoTextView.text = "Información sobre La Divina Comedia"

        button.setOnClickListener {
            (activity as MainActivity).navigateToFragment(DateFragment())
        }

        return view
    }
}