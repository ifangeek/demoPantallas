package com.example.interfacestaxi.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.interfacestaxi.R
import kotlinx.android.synthetic.main.item_job.view.*

class RVJob : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var titleJob = listOf("JAVA Developer", "KOTLIN Developer", "DBA SQL", "AWS Architect","APPLE Developer")

    var company = listOf("Alphabet", "Facebook", "IBM", "MICROSOFT","APPLE")

    var timeJob = listOf("6m","10m","3y","3y","1y")

    var images = listOf(R.drawable.ic_alphabet,R.drawable.ic_facebook,R.drawable.ic_ibm,R.drawable.ic_microsoft,R.drawable.ic_apple)

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(R.layout.item_job,parent,false)
        return RVJobHolder(v)
    }

    override fun getItemCount(): Int {
        return titleJob.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       holder.itemView.title_job.text = titleJob.get(position)
        holder.itemView.tv_company.text = company.get(position)
        holder.itemView.tv_time.text = timeJob.get(position)
        holder.itemView.sdv_job.setImageResource(images.get(position))
    }

    class RVJobHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}