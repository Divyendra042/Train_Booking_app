package com.example.trainbookingapp.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trainbookingapp.databinding.ActivityMainBinding
import com.example.trainbookingapp.viewmodel.MainViewModel
import android.content.Intent
import com.example.trainbookingapp.data.Train
import com.example.trainbookingapp.ui.BookingActivity
import com.example.trainbookingapp.ui.TrainListAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val trainAdapter = TrainListAdapter { selectedTrain ->
        val intent = Intent(this, BookingActivity::class.java)
        intent.putExtra("train_name", selectedTrain.name)
        intent.putExtra("train_fare", selectedTrain.fare)
        startActivity(intent)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        observeTrains()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = trainAdapter
        }
    }

    private fun observeTrains() {
        viewModel.trains.observe(this) { trainList ->
            trainAdapter.submitList(trainList)
        }
    }

    private fun onTrainClick(train: Train) {
        val intent = Intent(this, BookingActivity::class.java)
        intent.putExtra("train_name", train.name)
        startActivity(intent)
    }
}
