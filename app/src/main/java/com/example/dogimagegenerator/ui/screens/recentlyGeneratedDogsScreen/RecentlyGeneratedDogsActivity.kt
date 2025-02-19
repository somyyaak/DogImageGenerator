package com.example.dogimagegenerator.ui.screens.recentlyGeneratedDogsScreen

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogimagegenerator.R
import com.example.dogimagegenerator.SharedPreferencesHelper
import com.example.dogimagegenerator.databinding.ActivityRecentlyGeneratedDogsBinding
import com.example.dogimagegenerator.ui.screens.recentlyGeneratedDogsScreen.adapter.GeneratedDogsCacheAdapter

class RecentlyGeneratedDogsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecentlyGeneratedDogsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecentlyGeneratedDogsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.recentDogsToolbar)
        supportActionBar?.apply {
            title = "My Recently Generated Dogs!"
            setDisplayHomeAsUpEnabled(true)
        }
        binding.recentDogsToolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        binding.recentlyGeneratedDogsRecyclerView.apply {
            adapter = GeneratedDogsCacheAdapter(SharedPreferencesHelper(this@RecentlyGeneratedDogsActivity).getDogImages())
            layoutManager = LinearLayoutManager(this@RecentlyGeneratedDogsActivity, LinearLayoutManager.HORIZONTAL, false)
        }
        binding.clearDogsCta.apply{
            setBackgroundColor(Color.rgb(66,134, 244))
            text = "Clear Dogs!"
            setOnClickListener {
                SharedPreferencesHelper(this@RecentlyGeneratedDogsActivity).clearDogImages()
                binding.recentlyGeneratedDogsRecyclerView.adapter = GeneratedDogsCacheAdapter(SharedPreferencesHelper(this@RecentlyGeneratedDogsActivity).getDogImages())
            }
        }
    }
}