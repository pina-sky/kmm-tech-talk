//
//  RocketLaunchView.swift
//  iosApp
//
//  Created by Hugo Pires Pina Fora on 03/06/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct RocketLaunchView: View {
    let rocketLaunch: RocketLaunch

    var body: some View {
        VStack(alignment: .leading) {
            Text("\(rocketLaunch.missionName)")
                .font(.headline)
            Spacer()
            HStack {
                Text("Flight Number: \(rocketLaunch.flightNumber)")
            }
        }
        .padding()
    }
}

struct RocketLaunchView_Previews: PreviewProvider {
    static var rocketLaunch = RocketLaunch(
        flightNumber: 2,
        missionName: "Mission 1",
        launchYear: 1990,
        launchDateUTC: "1111111",
        rocket: Rocket.init(id: "1", name: "Rocket 1", type: "Type 1"),
        details: nil,
        launchSuccess: false,
        links: Links(missionPatchUrl: nil, articleUrl: nil)
    )
    static var previews: some View {
        RocketLaunchView(rocketLaunch: rocketLaunch)
            .previewLayout(.fixed(width: 400, height: 60))
    }
}
