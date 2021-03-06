package com.example.diegopacheco.demopantallas.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.diegopacheco.demopantallas.R
import kotlinx.android.synthetic.main.item_profile.view.*

class AdapterRecycler(callback:RVCallback) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    val mCallback = callback
    interface RVCallback {
        fun onClick(texto:String,posicion:Int)
    }



    var name = listOf("Diego","Josue","Alex","Luis",
            "Gianfranco","Aaron")

    var lastName= listOf("Pacheco","Rosas","Caparachin","Purizaga","Monzon","Cordero")

    var ids = listOf("1","2","3","4","5","6")

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(R.layout.item_profile,parent,false)
        return RVConstraintView(v)
    }

    override fun getItemCount(): Int {
        return name.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val nombre = name[position]
        holder.itemView.tvName.text = name[position]
        holder.itemView.tvLastName.text = lastName[position]
        holder.itemView.idUser.text = ids[position]
        holder.itemView.ivProfile.setImageResource(R.drawable.ic_account_circle_black_24dp)
        holder.itemView.setOnClickListener {
                mCallback.onClick(nombre,position)
        }


        /*holder.itemView.setOnClickListener {
            Toast.makeText(context, "onClick en recyclerView", Toast.LENGTH_SHORT).show()
        }

        holder.itemView.ivProfile.setOnClickListener {
            Toast.makeText(context,"onClick en un imageView",Toast.LENGTH_SHORT).show()
        }*/

    }

    class RVConstraintView(itemView: View) : RecyclerView.ViewHolder(itemView)

}