package com.example.diegopacheco.demopantallas

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class RelativeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relative)

        Toast.makeText(this,"Relative Activity", Toast.LENGTH_SHORT).show()
    }
}
