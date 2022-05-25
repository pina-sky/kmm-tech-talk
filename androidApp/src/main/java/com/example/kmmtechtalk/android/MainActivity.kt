package com.example.kmmtechtalk.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.state.observe(this) {
            val tv: TextView = findViewById(R.id.text_view)
            tv.text = it.joinToString(", ")
        }
    }

    override fun onResume() {
        super.onResume()

        viewModel.fetchRocketLaunches()
    }
}
