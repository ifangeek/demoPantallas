package com.example.diegopacheco.demopantallas

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.diegopacheco.demopantallas.adapter.AdapterRecycler
import kotlinx.android.synthetic.main.activity_constraint3.*

class Constraint3Activity : AppCompatActivity() {

    private lateinit var adapter: AdapterRecycler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint3)

        adapter = AdapterRecycler(this)
        rvProfile.adapter = adapter
    }
}
