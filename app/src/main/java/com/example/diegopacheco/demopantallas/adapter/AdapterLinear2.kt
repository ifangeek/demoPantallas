package com.example.diegopacheco.demopantallas.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import com.example.diegopacheco.demopantallas.R
import com.example.diegopacheco.demopantallas.model.Model
import kotlinx.android.synthetic.main.item_profile_linear.view.*

class AdapterLinear2
constructor(context: Context) : ArrayAdapter<String>(context,0, mutableListOf()) {


    var inflater : LayoutInflater = LayoutInflater.from(context)




    var name = listOf("Diego", "Josue", "Alex", "Luis",
            "Gianfranco", "Aaron")

    var lastName = listOf("Pacheco", "Rosas", "Caparachin", "Purizaga", "Monzon", "Cordero")

    var ids = listOf("1", "2", "3", "4", "5", "6")

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        var convertViews = convertView

        if (convertViews == null){
            convertViews = inflater.inflate(R.layout.item_profile_linear,null)
            convertViews!!.tvNameLinear.text = name[position]
            convertViews.tvLastNameLinear.text = lastName[position]
            convertViews.tvIdLinear.text = ids[position]
        }

        return convertViews
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
       return  name.size
    }
}