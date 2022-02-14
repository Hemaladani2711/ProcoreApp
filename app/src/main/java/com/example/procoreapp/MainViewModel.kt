package com.example.procoreapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.procoreapp.modal.Pokemon

class MainViewModel(val repository: MainRepository= MainRepository()):ViewModel()  {
    fun fetchData():LiveData<Pokemon> = repository.downloadData()
}