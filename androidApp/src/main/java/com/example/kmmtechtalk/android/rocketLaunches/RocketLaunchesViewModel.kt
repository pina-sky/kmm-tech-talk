package com.example.kmmtechtalk.android.rocketLaunches

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.kmmtechtalk.feature.spacex.model.RocketLaunch
import com.kmmtechtalk.feature.spacex.usecase.GetRocketLaunchesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

class RocketLaunchesViewModel(
    val getRocketLaunchesUseCase: GetRocketLaunchesUseCase
) : ViewModel() {

    private var _state: MutableStateFlow<RocketLaunchesState> = MutableStateFlow(RocketLaunchesState.Loading)
    val state: LiveData<RocketLaunchesState>
        get() = _state.asLiveData()

    fun fetchRocketLaunches() {
        viewModelScope.launch {
            try {
                val rocketLaunches = getRocketLaunchesUseCase()
                _state.value = RocketLaunchesState.Success(rocketLaunches)
            } catch (t: Throwable) {
                _state.value = RocketLaunchesState.Error
            }
        }
    }
}

sealed class RocketLaunchesState {
    object Loading : RocketLaunchesState()
    object Error : RocketLaunchesState()
    data class Success(val rocketLaunches: List<RocketLaunch>) : RocketLaunchesState()
}

val rocketLaunchesViewModelModule = module {
    viewModelOf(::RocketLaunchesViewModel)
}
