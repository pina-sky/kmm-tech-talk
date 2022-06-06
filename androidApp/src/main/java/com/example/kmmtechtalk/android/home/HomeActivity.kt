package com.example.kmmtechtalk.android.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kmmtechtalk.android.databinding.ActivityHomeBinding
import com.example.kmmtechtalk.android.platformVersion.PlatformVersionActivity
import com.example.kmmtechtalk.android.rocketLaunches.RocketLaunchesActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRocketLaunches.setOnClickListener {
            startActivity(
                Intent(this, RocketLaunchesActivity::class.java)
            )
        }

        binding.btnPlatformVersion.setOnClickListener {
            startActivity(
                Intent(this, PlatformVersionActivity::class.java)
            )
        }
    }
}
