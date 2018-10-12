package com.example.diegopacheco.demopantallas

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        var IDENTIFY_REQUEST = 1
    }


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
            startActivityForResult(intent, IDENTIFY_REQUEST)
        }





        btnLinear2.setOnClickListener {
            val intent = Intent(this@MainActivity,Linear2Activity::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == IDENTIFY_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                var result: String = data?.getStringExtra("result").toString()
                Log.d(MainActivity::class.java.name, result)
                Toast.makeText(this, "Resultado del 2do Activity -> $result", Toast.LENGTH_SHORT).show()
            } else
                if (resultCode == Activity.RESULT_CANCELED) {
                    Toast.makeText(this, "Fallo ", Toast.LENGTH_SHORT).show()
                }
        }
    }
}
