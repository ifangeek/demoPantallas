package com.example.diegopacheco.demopantallas.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.diegopacheco.demopantallas.R
import kotlinx.android.synthetic.main.item_profile_linear.view.*

class AdapterLinear2
constructor(context: Context) : BaseAdapter() {


    var mcontext  = context

    var name = listOf("Diego", "Josue", "Alex", "Luis",
        "Gianfranco", "Aaron")

    var lastName = listOf("Pacheco", "Rosas", "Caparachin", "Purizaga", "Monzon", "Cordero")

    var ids = listOf("1", "2", "3", "4", "5", "6")

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItem(position: Int): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemId(position: Int): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}