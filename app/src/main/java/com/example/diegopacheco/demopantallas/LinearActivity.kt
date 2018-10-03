package com.example.diegopacheco.demopantallas

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class LinearActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear)

        Toast.makeText(this,"Linear Activity", Toast.LENGTH_SHORT).show()
    }
}
