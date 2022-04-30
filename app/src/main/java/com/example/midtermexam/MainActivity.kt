package com.example.midtermexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.midtermexam.databinding.ActivityMainBinding
import com.example.midtermexam.view.activity.LoginActivity
import com.example.midtermexam.util.start

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
    }
}