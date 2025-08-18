import SwiftUI
import shared

@main
struct iOSApp: App {
    
    init(){
        
        KoinInitializeKt.doInitKoin()
        
    }
    
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
