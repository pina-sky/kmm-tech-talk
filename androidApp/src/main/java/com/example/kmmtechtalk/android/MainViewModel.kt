package com.example.kmmtechtalk.android

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

class MainViewModel(
    val getRocketLaunchesUseCase: GetRocketLaunchesUseCase
) : ViewModel() {

    private var _state: MutableStateFlow<List<RocketLaunch>> = MutableStateFlow(emptyList())
    val state: LiveData<List<RocketLaunch>>
        get() = _state.asLiveData()

    fun fetchRocketLaunches() {
        viewModelScope.launch {
            _state.value = getRocketLaunchesUseCase()
        }
    }
}

val mainViewModelModule = module {
    viewModelOf(::MainViewModel)
}
