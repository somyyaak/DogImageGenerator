package com.example.dogimagegenerator.ui.screens.generateDogsScreen

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.dogimagegenerator.DogGeneratorViewModelFactory
import com.example.dogimagegenerator.databinding.ActivityGenerateDogsBinding
import com.example.dogimagegenerator.ui.screens.DogGeneratorApplication
import com.example.dogimagegenerator.ui.screens.generateDogsScreen.viewModel.DogGeneratorViewModel

class GenerateDogsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGenerateDogsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGenerateDogsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.generateDogsToolbar)
        supportActionBar?.apply {
            title = "Generate Dogs"
            setDisplayHomeAsUpEnabled(true)
        }
        binding.generateDogsToolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        val viewModel = ViewModelProvider(this, DogGeneratorViewModelFactory((application as DogGeneratorApplication).dogGeneratorRepository))[DogGeneratorViewModel::class.java]
        binding.generateDogsCta.setOnClickListener {
            viewModel.generateDog()
        }
        binding.generateDogsCta.apply {
            setBackgroundColor(Color.rgb(66,134, 244))
            text = "Generate!"
            setOnClickListener {
                viewModel.generateDog()
            }
        }
        viewModel.dogImage.observe(this) {
            Glide.with(this).load(it).into(binding.generatedDogImage)
        }

    }
}