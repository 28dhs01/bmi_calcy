package com.dhruv.bmicalcy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dhruv.bmicalcy.databinding.ActivityResultBinding

class ResultActivity: AppCompatActivity() {
    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_HEIGHT = "extra_height"
        const val EXTRA_WEIGHT = "extra_weight"
    }
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent?.extras?.getString(EXTRA_NAME).toString()
        val height = intent?.extras?.getDouble(EXTRA_HEIGHT, 0.00)
        val weight = intent?.extras?.getDouble(EXTRA_WEIGHT, 0.00)
        val result = weight!! /(height!! * height!!)
        binding.tvResult.text = "%.2f".format(result)

        when(result){
            in 0.00..18.49 -> {
                binding.tvResultOverview.text = "underweight"
                binding.tvAdvice.text = "Don't worry $name \neat bananas daily and you will see the magic within a month"
            }
            in 18.50..25.00 -> {
                binding.tvResultOverview.text = "normal"
                binding.tvAdvice.text = "Well done $name \nkeep following your process"
            }
            else ->{
                binding.tvResultOverview.text = "overweight"
                binding.tvAdvice.text = "Don't worry $name \nplay some outdoor games like badminton or volleyball and you will see the magic within a month"
            }

        }
    }
}