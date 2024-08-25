package com.example.myapplicationtestsavedinstancestate

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.myapplicationtestsavedinstancestate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var countViewModel: CountViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        countViewModel = ViewModelProvider(this)[CountViewModel::class.java]



        countViewModel.currentNumber.observe(this) {
            binding.TV.text = it.toString()
        }

        binding.BTNCLICK.setOnClickListener {
            countViewModel.currentNumber.value = ++countViewModel.number

        }
    }

}