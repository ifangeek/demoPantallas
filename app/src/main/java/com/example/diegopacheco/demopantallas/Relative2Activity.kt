package com.example.diegopacheco.demopantallas

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import android.widget.Toast
import com.example.diegopacheco.demopantallas.adapter.AdapterRecycler
import kotlinx.android.synthetic.main.activity_constraint3.*
import kotlinx.android.synthetic.main.activity_relative2.*

class Relative2Activity : AppCompatActivity(),AdapterRecycler.RVCallback {

    private lateinit var adapter: AdapterRecycler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relative2)

        adapter = AdapterRecycler(this,this)
        val layout = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        rvProfile.layoutManager = layout
        rvProfileRecycler.adapter = adapter

    }

    override fun onClick(context: Context) {
        Toast.makeText(context, "onClick en recyclerView", Toast.LENGTH_SHORT).show()
    }
}
