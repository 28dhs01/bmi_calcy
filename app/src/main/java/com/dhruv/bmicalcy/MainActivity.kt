package com.dhruv.bmicalcy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dhruv.bmicalcy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
            binding.btnCalculate.setOnClickListener {
                if(binding.etHeight.text.toString().isEmpty() && binding.etWeight.text.toString().isNotEmpty()){
                    Toast.makeText(this,"Enter appropriate height",Toast.LENGTH_SHORT).show()
                }
                else if( binding.etWeight.text.toString().isEmpty() && binding.etHeight.text.toString().isNotEmpty()){
                    Toast.makeText(this,"Enter appropriate weight",Toast.LENGTH_SHORT).show()
                }
                else if(binding.etHeight.text.toString().isEmpty() && binding.etWeight.text.toString().isEmpty()){
                    Toast.makeText(this,"Enter appropriate height and weight",Toast.LENGTH_SHORT).show()
                }
                else if( binding.etHeight.text.toString().toDouble()>5.00 ){
                    Toast.makeText(this,"invalid height",Toast.LENGTH_SHORT).show()
                }
                else if(binding.etHeight.text.toString().isNotEmpty() && binding.etWeight.text.toString().isNotEmpty()){
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
}