//
//  RocketLaunchesScreen.swift
//  iosApp
//
//  Created by Hugo Pires Pina Fora on 03/06/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct RocketLaunchesView: View {
    @StateObject private var viewModel = ViewModel()
    
    var body: some View {
        List {
            ForEach(viewModel.rocketLaunches, id: \.flightNumber) { launch in
                RocketLaunchView(rocketLaunch: launch)
            }
        }
        .onDisappear {
            viewModel.onViewDisappear()
        }
        .navigationTitle("RocketLaunches")
    }
}

struct RocketLaunchesScreen_Previews: PreviewProvider {
    static var previews: some View {
        NavigationView {
            RocketLaunchesView()
        }
    }
}

