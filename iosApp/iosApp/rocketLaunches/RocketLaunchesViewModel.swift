//
//  RocketLaunchesViewModel.swift
//  iosApp
//
//  Created by Hugo Pires Pina Fora on 03/06/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import shared


extension RocketLaunchesView {
    @MainActor class ViewModel: ObservableObject {
        @Published var rocketLaunches: [RocketLaunch] = []
        
        init() {
            fetchRocketLaunches()
        }
        
        func fetchRocketLaunches() {
            let getRocketLaunchesUseCase = GetRocketLaunchesUseCaseFactory().buildGetRocketLaunchesUseCase()
            getRocketLaunchesUseCase.invoke() { (result, error) in
                if result != nil {
                    self.rocketLaunches = result!
                }
            }
        }
    }
}
