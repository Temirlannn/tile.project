package com.itacademy.myapplication.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.itacademy.myapplication.R
import com.itacademy.myapplication.models.Model

class File_adapter(
    private val array: ArrayList<Model>,
    val context: EditDeleteListener
    ) :
    RecyclerView.Adapter<File_adapter.ViewHolder>() {

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        val mama = item.findViewById<TextView>(R.id.description_short)
        val nana = item.findViewById<TextView>(R.id.description_detail)

        val btnEditor = item.findViewById<ImageButton>(R.id.btn_editor)
        val btnDelete = item.findViewById<ImageButton>(R.id.btn_delete)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.result_cell, parent, false)

        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = array[position]

        holder.mama.text = item.title
        holder.nana.text = item.content

    }

    override fun getItemCount(): Int {
        return array.size
    }
}
////////////////////////////////////////////////////
interface EditDeleteListener{
    fun editClicked(editEvent : Model, position: Int)
    fun deleteCliced(editEvent : Model, position: Int)
}

