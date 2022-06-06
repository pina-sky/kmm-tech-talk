package com.example.kmmtechtalk.android.rocketLaunches

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kmmtechtalk.android.databinding.ItemViewRocketLaunchBinding
import com.kmmtechtalk.feature.spacex.model.RocketLaunch

class RocketLaunchesAdapter() :
    ListAdapter<RocketLaunch, RocketLaunchesAdapter.RocketLaunchHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RocketLaunchHolder {
        val view = ItemViewRocketLaunchBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RocketLaunchHolder(view)
    }

    override fun onBindViewHolder(holder: RocketLaunchHolder, position: Int) =
        holder.bind(getItem(position))

    class RocketLaunchHolder(
        private val binding: ItemViewRocketLaunchBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RocketLaunch) {
            binding.txtMissionName.text = item.missionName
            binding.txtFlightNumber.text = item.flightNumber.toString()
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<RocketLaunch>() {
            override fun areItemsTheSame(
                oldItem: RocketLaunch,
                newItem: RocketLaunch
            ) = oldItem.flightNumber == newItem.flightNumber

            override fun areContentsTheSame(
                oldItem: RocketLaunch,
                newItem: RocketLaunch
            ) = oldItem == newItem
        }
    }
}