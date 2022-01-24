package com.itacademy.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.itacademy.myapplication.R
import com.itacademy.myapplication.models.Model


class second_fragment(
    val title: String?,
    val content: String?,
    val content2: String?,
    val content3: String?,
    val content4: String?,
    val content5: String?,
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
    lateinit var contentEt2: EditText
    lateinit var contentEt3: EditText
    lateinit var contentEt4: TextView
    lateinit var contentEt5: TextView

    lateinit var saveBtn: Button
    lateinit var baclbtn: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_second_fragment, container, false)

        titleEt = view.findViewById(R.id.short_description)
        contentEt = view.findViewById(R.id.detail_description)
        contentEt2 = view.findViewById(R.id.detailed_description_editText)
        contentEt3 = view.findViewById(R.id.user_editText)
        contentEt4 = view.findViewById(R.id.start_event)
        contentEt5 = view.findViewById(R.id.end_event)


        titleEt.setText(title)
        contentEt.setText(content)
        contentEt2.setText(content2)
        contentEt3.setText(content3)
        contentEt4.setText(content4)
        contentEt5.setText(content5)

        saveBtn = view.findViewById(R.id.btn)
        baclbtn = view.findViewById(R.id.back)


        saveBtn.setOnClickListener {

            val title = titleEt.text.toString()
            val content = contentEt.text.toString()
            val content2 = contentEt2.text.toString()
            val content3 = contentEt3.text.toString()
            val content4 = contentEt4.text.toString()
            val content5 = contentEt5.text.toString()

            val newEvent = Model(title,content,content2,content3,content4,content5)

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