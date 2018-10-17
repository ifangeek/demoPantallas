package com.example.interfacestaxi

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    companion object {
        const val REQUEST_CODE = 100
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       /* val intents : Intent = intent

        try{
            nombre = intents.getStringExtra("nombre").toString()
            apellido = intents.getStringExtra("apellido").toString()

        } catch (ex:Exception) {
            ex.printStackTrace()
        }
*/

//        Log.d(MainActivity::class.java.name,"nombre -> $nombre   apellido -> $apellido")



        btnTestAFR.setOnClickListener {
            val intent = Intent(this@MainActivity,SecondActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }



        btnTestRV.setOnClickListener {
            val intent = Intent(this@MainActivity,JobsActivity::class.java)
            startActivity(intent)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(REQUEST_CODE == requestCode){
            if(resultCode == Activity.RESULT_OK) {

                tvWelcome.text = data?.getStringExtra("message").toString()
            } else
                if(resultCode == Activity.RESULT_CANCELED){
                    tvWelcome.text = getString(R.string.operation_cancel)
                }
        }
    }

}
