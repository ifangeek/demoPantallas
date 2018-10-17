package com.example.interfacestaxi

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            for (index in 0 until resources.configuration.locales.size())
                Log.d(LoginActivity::class.java.name, "locale -> ${resources.configuration.locales.get(index)}")
        } else {
            var locale = resources.configuration.locale
            Log.d(LoginActivity::class.java.name, "locale -> $locale")
        }

        btnIngresar.setOnClickListener{
            Login()
        }

        tvRegister.setOnClickListener {
            val intent = Intent(this@LoginActivity, registerActivity::class.java)
            startActivity(intent)
        }
    }

    fun Login() {
        if (etUsername != null  && etPassword != null ) {
            if(etUsername.text.isBlank()  && etPassword.text.isBlank()) {
              Toast.makeText(this,R.string.text_in_blank,Toast.LENGTH_SHORT).show()
            } else{
                if (etUsername.text.toString() == "diego" &&
                        etPassword.text.toString() == "123456") {
                    Toast.makeText(this, R.string.message_done, Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@LoginActivity,MainActivity::class.java)
                    startActivity(intent)

                } else {
                    Toast.makeText(this, R.string.message_incorrect_credentials, Toast.LENGTH_SHORT).show()
                }
            }
        }else {
            Toast.makeText(this,R.string.message_error,Toast.LENGTH_SHORT).show()
        }


    }
}
