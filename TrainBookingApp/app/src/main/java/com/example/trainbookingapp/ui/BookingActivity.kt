package com.example.trainbookingapp.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.trainbookingapp.databinding.ActivityBookingBinding

class BookingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBookingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val trainName = intent.getStringExtra("train_name") ?: "Unknown Train"
        val trainFare = intent.getDoubleExtra("train_fare", 0.0)

        binding.trainNameTextView.text = trainName
        binding.fareTextView.text = "Fare: ₹$trainFare" // 💰 Show the fare

        binding.bookButton.setOnClickListener {
            val passengerName = binding.passengerNameEditText.text.toString().trim()

            if (passengerName.isNotEmpty()) {
                Toast.makeText(
                    this,
                    "🎫 Booking confirmed for $passengerName on $trainName!\nTotal Fare: ₹$trainFare",
                    Toast.LENGTH_LONG
                ).show()
                finish()
            } else {
                Toast.makeText(this, "Please enter passenger name.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
