package com.itacademy.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.itacademy.myapplication.Constant
import com.itacademy.myapplication.R
import com.itacademy.myapplication.adapters.EditDeleteListener
import com.itacademy.myapplication.adapters.File_adapter
import com.itacademy.myapplication.models.Model

class first_fragment : Fragment(){
    lateinit var recyclerView: RecyclerView
    lateinit var Add : FloatingActionButton
    lateinit var adapter: File_adapter

    private var isEdit: Boolean = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first_fragment, container,false)

        recyclerView = view.findViewById(R.id.recycler_view)

        adapter = File_adapter(Constant.app, object: EditDeleteListener{
            override fun editClicked(editEvent: Model, position: Int) {
                isEdit = true
                showEditFragment(editEvent.title, editEvent.content,position)
            }

            override fun deleteCliced(editEvent: Model, position: Int) {
                Constant.app.remove(editEvent)
                adapter.notifyDataSetChanged()
            }
        })
        recyclerView.adapter = adapter
        Add = view.findViewById(R.id.btn_add)
        Add.setOnClickListener {
            isEdit = false
            showEditFragment(null,null,0)
        }
        return view
    }
    private fun showEditFragment(title: String?, content : String?, position: Int){
        second_fragment(title,content,object : EventAddListener{
            override fun onEventAdded(newEvent: Model) {
                if (isEdit){
                    Constant.app[position] = newEvent
                } else {
                    Constant.app.add(newEvent)
                }
                adapter.notifyDataSetChanged()
            }
        }).show(childFragmentManager,"second_fragment")
    }
}