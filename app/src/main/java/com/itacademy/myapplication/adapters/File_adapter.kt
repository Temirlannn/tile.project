package com.itacademy.myapplication.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.itacademy.myapplication.R
import com.itacademy.myapplication.models.Model


class File_adapter(private val array: ArrayList<Model>, val context: FragmentActivity) : RecyclerView.Adapter<File_adapter.ViewHolder>() {

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        val tv_event = item.findViewById<TextView>(R.id.description_short)
        val event_tv = item.findViewById<TextView>(R.id.description_detail)

        val btnEditor = item.findViewById<ImageButton>(R.id.btn_editor)
        val btnDelete = item.findViewById<ImageButton>(R.id.btn_delete)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.result_cell, parent, false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = array[position]

        holder.tv_event.text = item.short_descriotion
        holder.event_tv.text = item.detali_description

    }

    override fun getItemCount(): Int {
        return array.size
    }
}

