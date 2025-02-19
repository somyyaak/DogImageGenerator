package com.example.dogimagegenerator.data.network

import android.content.Context
import com.example.dogimagegenerator.SharedPreferencesHelper
import com.example.dogimagegenerator.data.models.GeneratedDog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface GeneratedDogsRepository {
    suspend fun generateDog(
    ): Result<GeneratedDog>

    suspend fun saveLocalCache(dogImage: String)
}

class GeneratedDogsRepositoryImpl (private val service: GenerateDogsService, private val context: Context): GeneratedDogsRepository {
    override suspend fun generateDog(): Result<GeneratedDog>  = withContext(
        Dispatchers.IO){
        try{
            val result = service.generateDog()
            Result.Success(result)
        }catch (exception: Exception){
            Result.Error(exception)
        }
    }

    override suspend fun saveLocalCache(dogImage: String) {
        SharedPreferencesHelper(context).saveDogImage(dogImage)
    }

}