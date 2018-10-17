package com.example.interfacestaxi

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class registerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnRegister.setOnClickListener {

            Registro()
            val intent = Intent(this@registerActivity,MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun Registro() {

        if(etName.text.isNullOrBlank() || etLastName.text.isNullOrBlank()
                || etPassword.text.isNullOrBlank() || etPhone.text.isNullOrBlank()
                || etEmail.text.isNullOrBlank()){
            Toast.makeText(this,"No dejar campos vacios para el registro", Toast.LENGTH_SHORT).show()
        } else{
            Toast.makeText(this,"Registro exitoso", Toast.LENGTH_SHORT).show()
        }



    }
}
