package com.example.diegopacheco.demopantallas

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class Constraint2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint2)

        Toast.makeText(this,"Constraint 2  Activity", Toast.LENGTH_SHORT).show()
    }
}
