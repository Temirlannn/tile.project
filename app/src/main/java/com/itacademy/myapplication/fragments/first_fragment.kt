package com.itacademy.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.itacademy.myapplication.Constant
import com.itacademy.myapplication.R
import com.itacademy.myapplication.adapters.File_adapter
import com.itacademy.myapplication.models.Model

class first_fragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var btnADD: FloatingActionButton
    lateinit var data: Model

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first_fragment, container, false)

        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.adapter = File_adapter(Constant.app,requireActivity())
        btnADD = view.findViewById(R.id.btn_add)

        btnADD.setOnClickListener {
       // отправка оста

            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.container_fragment, second_fragment()).commit()

        }
        return view

    }
}