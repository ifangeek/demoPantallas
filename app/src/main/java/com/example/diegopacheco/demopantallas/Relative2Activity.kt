package com.example.diegopacheco.demopantallas

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import com.example.diegopacheco.demopantallas.adapter.AdapterConstraint3
import kotlinx.android.synthetic.main.activity_constraint3.*
import kotlinx.android.synthetic.main.activity_relative2.*

class Relative2Activity : AppCompatActivity() {

    private lateinit var adapter : AdapterConstraint3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relative2)

        adapter = AdapterConstraint3()
        val layout = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        rvProfile.layoutManager = layout
        rvProfileRecycler.adapter = adapter

    }
}
