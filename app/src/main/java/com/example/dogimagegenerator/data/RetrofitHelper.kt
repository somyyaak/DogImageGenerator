package com.example.dogimagegenerator.data

import com.example.dogimagegenerator.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    fun getInstance() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.dogImageBaseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}