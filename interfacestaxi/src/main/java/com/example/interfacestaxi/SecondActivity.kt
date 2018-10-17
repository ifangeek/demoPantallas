package com.example.interfacestaxi

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        btnSendMessage.setOnClickListener {
            val message = edtMessage.text.toString()
            val returnIntent = Intent()
            returnIntent.putExtra("message", message)
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }
    }
}
