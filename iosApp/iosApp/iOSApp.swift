import SwiftUI
import shared

@main
struct iOSApp: App {

    init() {
        KoinKt.doInitKoin()

        print("test");
    }

	var body: some Scene {
		WindowGroup {
            NavigationView {
                HomeView()
            }
		}
	}
}
