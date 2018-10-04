package com.example.diegopacheco.demopantallas

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

class ConstraintActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint)

        Toast.makeText(this,"Constraint Activity",Toast.LENGTH_SHORT).show()

    }
}
