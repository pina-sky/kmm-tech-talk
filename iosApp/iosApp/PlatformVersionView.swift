//
//  PlatformVersionView.swift
//  iosApp
//
//  Created by Hugo Pires Pina Fora on 03/06/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct PlatformVersionView: View {
    let greeting = Greeting().greeting()

    var body: some View {
        Text(greeting)
    }
}

struct PlatformVersionView_Previews: PreviewProvider {
    static var previews: some View {
        NavigationView {
            PlatformVersionView()
        }
    }
}
