package com.example.trainbookingapp.repository

import com.example.trainbookingapp.data.Train

class TrainRepository {

    fun getTrains(): List<Train> {
        return listOf(
            Train(1, "Express A", "Delhi", "Mumbai", "08:00 AM", 50, 999.0),
            Train(2, "Superfast B", "Bangalore", "Chennai", "09:30 AM", 30, 850.0),
            Train(3, "Local C", "Kolkata", "Patna", "07:45 AM", 60, 420.0),
            Train(4, "Shatabdi D", "Jaipur", "Agra", "06:00 AM", 40, 1200.0)
        )
    }
}

