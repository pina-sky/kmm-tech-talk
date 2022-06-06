package com.example.kmmtechtalk.android.rocketLaunches

import android.os.Bundle
import android.widget.LinearLayout.VERTICAL
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.kmmtechtalk.android.databinding.ActivityRocketLaunchesBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RocketLaunchesActivity : AppCompatActivity() {

    private val viewModel: RocketLaunchesViewModel by viewModel()

    private lateinit var binding: ActivityRocketLaunchesBinding

    private val rocketLaunchesAdapter = RocketLaunchesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRocketLaunchesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()

        viewModel.state.observe(this) {
            when (it) {
                is RocketLaunchesState.Success -> rocketLaunchesAdapter.submitList(it.rocketLaunches)
                is RocketLaunchesState.Error -> {}
                is RocketLaunchesState.Loading -> {}
            }
        }
    }

    override fun onResume() {
        super.onResume()

        viewModel.fetchRocketLaunches()
    }

    private fun initRecyclerView() {
        binding.rvRocketLaunches.apply {
            adapter = rocketLaunchesAdapter
            addItemDecoration(
                DividerItemDecoration(
                this@RocketLaunchesActivity,
                    VERTICAL
                )
            )
        }
    }
}