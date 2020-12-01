package com.example.sample_viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ExampleViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(ExampleViewModel::class.java)) {
            return ExampleViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}