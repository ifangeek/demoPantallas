package com.example.diegopacheco.demopantallas

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.diegopacheco.demopantallas.adapter.AdapterListView
import kotlinx.android.synthetic.main.activity_linear2.*

class Linear2Activity : AppCompatActivity() {



    private lateinit var adapter : AdapterListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear2)

        adapter = AdapterListView(this)
        listView.adapter = adapter

    }
}
