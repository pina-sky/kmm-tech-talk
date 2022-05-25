package com.kmmtechtalk.feature.spacex.api

import com.kmmtechtalk.feature.spacex.model.Links
import com.kmmtechtalk.feature.spacex.model.Rocket
import com.kmmtechtalk.feature.spacex.model.RocketLaunch

class SpaceXApiImpl : SpaceXApi {
    override suspend fun getAllLaunches(): List<RocketLaunch> {
        return listOf(
            RocketLaunch(
                1,
                "Mission 1",
                2021,
                "date",
                Rocket("1", "Rocket 1","Type"),
                null,
                null,
                Links(null, null)
            ),
            RocketLaunch(
                2,
                "Mission 2",
                2022,
                "date",
                Rocket("2", "Rocket 2","Type"),
                null,
                null,
                Links(null, null)
            )
        )
    }
}