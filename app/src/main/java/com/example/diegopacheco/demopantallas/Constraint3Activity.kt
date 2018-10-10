package com.example.diegopacheco.demopantallas

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.diegopacheco.demopantallas.adapter.AdapterRecycler
import kotlinx.android.synthetic.main.activity_constraint3.*
import java.text.NumberFormat
import java.util.*

class Constraint3Activity : AppCompatActivity() {

    private lateinit var adapter: AdapterRecycler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint3)

        adapter = AdapterRecycler(this)
        rvProfile.adapter = adapter

        val nf = NumberFormat.getCurrencyInstance().currency
        val number = tvCurrencyNumber.text.toString()

        tvCurrencyNumber.text = "${nf.symbol}50"

        Log.d(Constraint3Activity::class.java.name, "Symbol Currency {${nf.symbol}}")

        Locale.getAvailableLocales().filter { it.language.toLowerCase() == "es" }.forEach { Log.d(Constraint3Activity::class.java.name, "Locale -> $it") }

        var locale = Locale("en", "PER")
        Log.d(Constraint3Activity::class.java.name, "Locale new -> $locale")
        Log.d(Constraint3Activity::class.java.name, "Currency new -> ${NumberFormat.getCurrencyInstance(locale).currency}")
        Log.d(Constraint3Activity::class.java.name, "Currency new -> ${NumberFormat.getCurrencyInstance(locale).currency.currencyCode}")
        Log.d(Constraint3Activity::class.java.name, "Currency new -> ${NumberFormat.getCurrencyInstance(locale).currency.displayName}")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            Log.d(Constraint3Activity::class.java.name, "Currency new -> ${NumberFormat.getCurrencyInstance(locale).currency.numericCode}")
//        Locale.getAvailableLocales().forEach { Log.d(Constraint3Activity::class.java.name, "Locale -> $it, Languague ${it.language}") }
    }
}
