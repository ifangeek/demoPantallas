package com.example.interfacestaxi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.interfacestaxi.adapter.RVJob
import kotlinx.android.synthetic.main.activity_jobs.*

class JobsActivity : AppCompatActivity() {

    private lateinit var adapter: RVJob

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jobs)

        adapter = RVJob()
        rvJob.adapter = adapter
    }
}
