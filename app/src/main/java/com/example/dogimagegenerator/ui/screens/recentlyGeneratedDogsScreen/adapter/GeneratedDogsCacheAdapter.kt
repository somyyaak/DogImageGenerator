package com.example.dogimagegenerator.ui.screens.recentlyGeneratedDogsScreen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dogimagegenerator.databinding.GeneratedDogItemBinding

class GeneratedDogsCacheAdapter(private val dogImages: List<String>) : RecyclerView.Adapter<GeneratedDogsCacheAdapter.DogItemViewHolder>()  {

    inner class DogItemViewHolder(binding: GeneratedDogItemBinding) :
        RecyclerView.ViewHolder(binding.root){
        val cachedDogImage: ImageView = binding.cacheDogImage
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogItemViewHolder {
        return DogItemViewHolder(
            GeneratedDogItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return dogImages.size
    }

    override fun onBindViewHolder(holder: DogItemViewHolder, position: Int) {
        Glide.with(holder.itemView).load(dogImages[position]).into(holder.cachedDogImage)
    }
}