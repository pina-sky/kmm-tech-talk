package com.example.kmmtechtalk.android.platformVersion

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kmmtechtalk.Greeting
import com.example.kmmtechtalk.android.databinding.ActivityPlatformVersionBinding

class PlatformVersionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlatformVersionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlatformVersionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtGreeting.text = Greeting().greeting()
    }
}