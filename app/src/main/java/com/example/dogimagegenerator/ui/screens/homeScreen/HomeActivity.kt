package com.example.dogimagegenerator.ui.screens.homeScreen

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dogimagegenerator.databinding.ActivityHomeBinding
import com.example.dogimagegenerator.ui.screens.generateDogsScreen.GenerateDogsActivity
import com.example.dogimagegenerator.ui.screens.recentlyGeneratedDogsScreen.RecentlyGeneratedDogsActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.randomGeneratorTitle.text = "Random Dog Generator!"
        binding.generateDogsCta.apply {
            setBackgroundColor(Color.rgb(66,134, 244))
            text = "Generate Dogs!"
            setOnClickListener {
                val intent = Intent(this@HomeActivity, GenerateDogsActivity::class.java)
                startActivity(intent)
            }
        }
        binding.recentlyGenerateDogsCta.apply {
            setBackgroundColor(Color.rgb(66, 134, 244))
            text = "My Recently Generated Dogs!"
            setOnClickListener {
                val intent = Intent(this@HomeActivity, RecentlyGeneratedDogsActivity::class.java)
                startActivity(intent)
            }
        }

    }
}