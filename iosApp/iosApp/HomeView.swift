//
//  HomeView.swift
//  iosApp
//
//  Created by Hugo Pires Pina Fora on 03/06/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct HomeView: View {
    
    @State private var selection: String? = nil

    
    var body: some View {
        
        VStack {
            NavigationLink(destination: RocketLaunchesView(), tag: "Rocket Launches", selection: $selection) {
                EmptyView()
            }
            
            NavigationLink(destination: PlatformVersionView(), tag: "Platform Version", selection: $selection) {
                EmptyView()
            }
            
            Button("Rocket Launches (Suspend Example)") {
                self.selection = "Rocket Launches"
            }
            .padding()
            .frame(maxWidth: .infinity)
            .background(Color.gray)
            .foregroundColor(Color.black)
            .clipShape(Capsule())
        
            Button("Platform Version (Expect & Actual Example)") {
                self.selection = "Platform Version"
            }
            .padding()
            .frame(maxWidth: .infinity)
            .background(Color.gray)
            .foregroundColor(Color.black)
            .clipShape(Capsule())
        }
        .navigationTitle("Home")
    }
}

struct HomeView_Previews: PreviewProvider {
    static var previews: some View {
        NavigationView {
            HomeView()
        }
    }
}
