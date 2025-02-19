package com.example.dogimagegenerator.data.network

import com.example.dogimagegenerator.Constants
import com.example.dogimagegenerator.data.models.GeneratedDog
import retrofit2.http.GET

interface GenerateDogsService {
    @GET(Constants.dogImageEndpoint)
    suspend fun generateDog(
   //     @Header("User-Agent") header: String = "Mozilla/5.0",
//        @Header("X-Api-Key") hApiKey: String,
//        @Query("q") q: String,
//        @Query("from") from: String,
//        @Query("sortBy") sortBy: String,
//        @Query("apiKey") apiKey: String
    ): GeneratedDog
}