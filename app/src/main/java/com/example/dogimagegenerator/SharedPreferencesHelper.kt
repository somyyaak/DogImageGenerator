package com.example.dogimagegenerator


import android.content.Context
import android.content.SharedPreferences
class SharedPreferencesHelper(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    companion object {
        private const val PREFS_NAME = "dog_image_prefs"
        private const val KEY_DOG_IMAGES = "dog_images"
        private const val MAX_SIZE = 20
    }

    fun saveDogImage(url: String) {
        val images = getDogImages().toMutableList()
        images.add(0, url) // Add new image to the beginning
        if (images.size > MAX_SIZE) {
            images.removeAt(images.size - 1) // Remove the oldest image if size exceeds MAX_SIZE
        }
        sharedPreferences.edit().putStringSet(KEY_DOG_IMAGES, images.toSet()).apply()
    }

    fun getDogImages(): List<String> {
        val images = sharedPreferences.getStringSet(KEY_DOG_IMAGES, emptySet()) ?: emptySet()
        var imagesList = arrayListOf<String>()
        for(image in images){
            imagesList.add(image)
        }
        return imagesList
    }

    fun clearDogImages() {
        sharedPreferences.edit().remove(KEY_DOG_IMAGES).apply()
    }
}