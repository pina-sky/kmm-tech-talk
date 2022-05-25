package com.example.kmmtechtalk.android

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.kmmtechtalk.feature.spacex.api.SpaceXApiImpl
import com.kmmtechtalk.feature.spacex.model.RocketLaunch
import com.kmmtechtalk.feature.spacex.repository.SpaceXRepositoryImpl
import com.kmmtechtalk.feature.spacex.usecase.GetRocketLaunchesUseCaseImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    // TODO repository should be injected in constructor
    private val spaceXApi = SpaceXApiImpl()
    private val spaceXRepository = SpaceXRepositoryImpl(spaceXApi)

    private var _state: MutableStateFlow<List<RocketLaunch>> = MutableStateFlow(emptyList())
    val state: LiveData<List<RocketLaunch>>
        get() = _state.asLiveData()

    fun fetchRocketLaunches() {
        viewModelScope.launch {
            _state.value = GetRocketLaunchesUseCaseImpl(spaceXRepository).invoke()
        }
    }
}