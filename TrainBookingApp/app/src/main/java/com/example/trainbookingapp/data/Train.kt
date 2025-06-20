package com.example.trainbookingapp.data

data class Train(
    val id: Int,
    val name: String,
    val origin: String,
    val destination: String,
    val departureTime: String,
    var availableSeats: Int,
    val fare: Double // 💰 added fare
)
