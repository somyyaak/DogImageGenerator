package com.example.dogimagegenerator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dogimagegenerator.data.network.GeneratedDogsRepository
import com.example.dogimagegenerator.ui.screens.generateDogsScreen.viewModel.DogGeneratorViewModel

class DogGeneratorViewModelFactory(private val repository: GeneratedDogsRepository ) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DogGeneratorViewModel(repository) as T
    }
}