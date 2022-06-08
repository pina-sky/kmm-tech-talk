//
//  RocketLaunchesViewModel.swift
//  iosApp
//
//  Created by Hugo Pires Pina Fora on 03/06/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import shared
import KMPNativeCoroutinesAsync

extension RocketLaunchesView {
    @MainActor class ViewModel: ObservableObject {
        @Published var rocketLaunches: [RocketLaunch] = []
        
        private let getRocketLaunchesUseCase = GetRocketLaunchesUseCaseFactory().buildGetRocketLaunchesUseCase()
        
        private var getRocketLaunchesHandle: Task<Void, Never>?
        
        init() {
            fetchRocketLaunches()
        }
        
        func fetchRocketLaunches() {
            getRocketLaunchesHandle = Task {
                let result = await asyncResult(for: getRocketLaunchesUseCase.invokeNative())
                if case let .success(launches) = result {
                    self.rocketLaunches = launches
                }
            }
        }
        
        func onViewDisappear() {
            getRocketLaunchesHandle?.cancel()
        }
    }
}
