package com.itacademy.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.itacademy.myapplication.R
import com.itacademy.myapplication.models.Model


class second_fragment(
    val title: String?,
    val content: String?,
    val eventListener: EventAddListener
) : BottomSheetDialogFragment() {

    //lateinit var name: EditText
    //lateinit var short: EditText
    //lateinit var detali: EditText
    //lateinit var user : EditText
    //lateinit var tv_start: TextView
    //lateinit var tv_end: TextView
    ///lateinit var btn: Button
    ///lateinit var back: Button

    lateinit var titleEt: EditText
    lateinit var contentEt: EditText
    lateinit var saveBtn: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_second_fragment, container, false)

        titleEt = view.findViewById(R.id.short_description)
        contentEt = view.findViewById(R.id.detail_description)


        titleEt.setText(title)
        contentEt.setText(content)

        saveBtn = view.findViewById(R.id.btn_done)

        saveBtn.setOnClickListener {
            val title = titleEt.text.toString()
            val content = contentEt.text.toString()

            val newEvent = Model(title,content)

            eventListener.onEventAdded(newEvent)
            dismiss()
        }
        //name = view.findViewById(R.id.name_editText)
        //short = view.findViewById(R.id.short_description_editText)
        //detali = view.findViewById(R.id.detailed_description_editText)
        //user = view.findViewById(R.id.user_notes_editText)
        //tv_start = view.findViewById(R.id.tv_start_event)
        //tv_end = view.findViewById(R.id.tv_end_event)
        //btn = view.findViewById(R.id.btn)
        //back = view.findViewById(R.id.back)
        return view
    }
}
interface EventAddListener {
    fun onEventAdded(newEvent: Model)
}