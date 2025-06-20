package com.example.trainbookingapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.trainbookingapp.R
import com.example.trainbookingapp.data.Train

class TrainListAdapter(
    private val onTrainClick: (Train) -> Unit
) : ListAdapter<Train, TrainListAdapter.TrainViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_train, parent, false)
        return TrainViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrainViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class TrainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(train: Train) {
            val trainName = itemView.findViewById<TextView>(R.id.trainNameTextView)
            val trainRoute = itemView.findViewById<TextView>(R.id.trainRouteTextView)
            val trainTime = itemView.findViewById<TextView>(R.id.trainTimeTextView)
            val availableSeats = itemView.findViewById<TextView>(R.id.availableSeatsTextView)
            val fare = itemView.findViewById<TextView>(R.id.fareTextView)

            trainName.text = train.name
            trainRoute.text = "From ${train.origin} to ${train.destination}"
            trainTime.text = "Departure: ${train.departureTime}"
            availableSeats.text = "Seats Available: ${train.availableSeats}"
            fare.text = "Fare: ₹${train.fare}"

            itemView.setOnClickListener {
                onTrainClick(train)
            }
        }

    }

    class DiffCallback : DiffUtil.ItemCallback<Train>() {
        override fun areItemsTheSame(oldItem: Train, newItem: Train): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Train, newItem: Train): Boolean = oldItem == newItem
    }
}
