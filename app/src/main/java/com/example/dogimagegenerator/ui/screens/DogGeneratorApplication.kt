package com.example.dogimagegenerator.ui.screens

import android.app.Application
import com.example.dogimagegenerator.data.RetrofitHelper
import com.example.dogimagegenerator.data.network.GenerateDogsService
import com.example.dogimagegenerator.data.network.GeneratedDogsRepository
import com.example.dogimagegenerator.data.network.GeneratedDogsRepositoryImpl

class DogGeneratorApplication : Application() {

    lateinit var dogGeneratorRepository: GeneratedDogsRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val dogGenerateService =
            RetrofitHelper.getInstance().create(GenerateDogsService::class.java)
        dogGeneratorRepository = GeneratedDogsRepositoryImpl(dogGenerateService, this)
    }
}