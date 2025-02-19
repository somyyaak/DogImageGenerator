package com.example.dogimagegenerator.ui.screens.generateDogsScreen.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogimagegenerator.data.network.GeneratedDogsRepository
import com.example.dogimagegenerator.data.network.Result
import kotlinx.coroutines.launch

class DogGeneratorViewModel(private val repository: GeneratedDogsRepository): ViewModel()  {
    private val _dogImage = MutableLiveData<String> ()
    var dogImage: LiveData<String> = _dogImage

    fun generateDog() {
        viewModelScope.launch {
            when(val result = repository.generateDog()){
                is Result.Success -> {
                    _dogImage.value = result.data.message
                    repository.saveLocalCache(result.data.message)
                }
                is Result.Error -> {

                }
            }
        }
    }
}