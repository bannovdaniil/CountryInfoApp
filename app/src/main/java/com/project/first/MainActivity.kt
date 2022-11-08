package com.project.first

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.project.first.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sumButton.setOnClickListener {
            val num1: Int = binding.num1.text.toString().toInt();
            val num2: Int = binding.num2.text.toString().toInt();

            val result = num1 + num2;
            binding.result.text = result.toString();
        }
    }
}