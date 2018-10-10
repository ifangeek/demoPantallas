package com.example.interfacestaxi

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            for (index in 0 until resources.configuration.locales.size())
                Log.d(MainActivity::class.java.name, "locale -> ${resources.configuration.locales.get(index)}")
        } else {
            var locale = resources.configuration.locale
            Log.d(MainActivity::class.java.name, "locale -> $locale")
        }

        tvRegister.setOnClickListener {
            val intent =  Intent(this@MainActivity,registerActivity::class.java)
            startActivity(intent)
        }
    }
}
