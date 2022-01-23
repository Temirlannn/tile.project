package com.itacademy.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.itacademy.myapplication.R


class second_fragment : Fragment() {
    lateinit var name: EditText
    lateinit var short: EditText
    lateinit var detali: EditText
    lateinit var user : EditText
    lateinit var tv_start: TextView
    lateinit var tv_end: TextView
    lateinit var btn: Button
    lateinit var back: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_second_fragment, container, false)

        name = view.findViewById(R.id.name_editText)
        short = view.findViewById(R.id.short_description_editText)
        detali = view.findViewById(R.id.detailed_description_editText)
        user = view.findViewById(R.id.user_notes_editText)
        tv_start = view.findViewById(R.id.tv_start_event)
        tv_end = view.findViewById(R.id.tv_end_event)
        btn = view.findViewById(R.id.btn)
        back = view.findViewById(R.id.back)

        btn.setOnClickListener {
        }
        return view
    }
}