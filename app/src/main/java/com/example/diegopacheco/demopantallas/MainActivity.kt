package com.example.diegopacheco.demopantallas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation()

    }


    fun navigation(){

        btnConstraint1.setOnClickListener {
            val intent = Intent(this@MainActivity,ConstraintActivity::class.java)
            startActivity(intent)
        }

        btnLinear1.setOnClickListener {
            val intent = Intent(this@MainActivity,LinearActivity::class.java)
            startActivity(intent)
        }

        btnRelative2.setOnClickListener {
            val intent = Intent(this@MainActivity,RelativeActivity::class.java)
            startActivity(intent)
        }

        btnConstraint2.setOnClickListener {
            val intent = Intent(this@MainActivity,Constraint2Activity::class.java)
            startActivity(intent)
        }
        btnConstraint3.setOnClickListener {
            val intent = Intent(this@MainActivity,Constraint3Activity::class.java)
            startActivity(intent)
        }





        btnLinear2.setOnClickListener {
            val intent = Intent(this@MainActivity,Linear2Activity::class.java)
            startActivity(intent)
        }
    }
}
