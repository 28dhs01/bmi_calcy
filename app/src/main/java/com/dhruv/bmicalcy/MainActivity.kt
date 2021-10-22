package com.dhruv.bmicalcy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dhruv.bmicalcy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCalculate.setOnClickListener {
            val name = binding.etName.text.toString()
            val height = binding.etHeight.text.toString().toDouble()
            val weight = binding.etWeight.text.toString().toDouble()
            val intent = Intent(this,ResultActivity::class.java)
            intent.putExtra(ResultActivity.EXTRA_NAME, name)
            intent.putExtra(ResultActivity.EXTRA_HEIGHT, height)
            intent.putExtra(ResultActivity.EXTRA_WEIGHT, weight)
            startActivity(intent)
        }
    }
}