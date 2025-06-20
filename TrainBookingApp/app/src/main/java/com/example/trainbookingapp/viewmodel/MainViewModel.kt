package com.example.trainbookingapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.trainbookingapp.data.Train
import com.example.trainbookingapp.repository.TrainRepository

class MainViewModel : ViewModel() {

    private val repository = TrainRepository()

    private val _trains = MutableLiveData<List<Train>>()
    val trains: LiveData<List<Train>> get() = _trains

    init {
        _trains.value = repository.getTrains()
    }
}
