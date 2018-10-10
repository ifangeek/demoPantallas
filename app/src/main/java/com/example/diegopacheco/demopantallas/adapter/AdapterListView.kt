package com.example.diegopacheco.demopantallas.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.example.diegopacheco.demopantallas.R
import kotlinx.android.synthetic.main.item_profile_linear.view.*

class AdapterListView
constructor(context: Context) : ArrayAdapter<String>(context, 0, mutableListOf()) {


    var name = listOf("Diego", "Josue", "Alex",
            "Gianfranco", "Aaron")

    var lastName = listOf("Pacheco", "Rosas", "Caparachin", "Monzon", "Cordero")

    var ids = listOf("1", "2", "3", "4", "5", "6")


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        val viewHolder: ViewHolder

        var convertViews = convertView

        if (convertViews == null) {

            convertViews = LayoutInflater.from(parent?.context).inflate(R.layout.item_profile_linear, parent, false)

            viewHolder = ViewHolder(convertViews)

            convertViews.setOnClickListener {
                Toast.makeText(context, "Posición del item :  $position", Toast.LENGTH_SHORT).show()
            }

            convertViews.tag = viewHolder

        } else {
            viewHolder = convertViews.tag as ViewHolder
        }
        viewHolder.tvNameLinear.text = name[position]
        viewHolder.tvLastNameLinear.text = lastName[position]
        viewHolder.tvIdLinear.text = ids[position]

        return convertViews
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return name.size
    }

    class ViewHolder(view: View) {
        var tvNameLinear: TextView = view.tvNameLinear
        var tvLastNameLinear: TextView = view.tvLastNameLinear
        var tvIdLinear: TextView = view.tvIdLinear
    }

}

