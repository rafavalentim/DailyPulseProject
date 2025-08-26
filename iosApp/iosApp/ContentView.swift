import SwiftUI
import shared

struct ContentView: View {
    
    var body: some View {
        ComposeView().ignoresSafeArea(.keyboard)
    }
    
    
}

struct ComposeView: UIViewControllerRepresentable {
    
    // O tipo associado (opcional declarar, mas ajuda o compilador)
        typealias UIViewControllerType = UIViewController
    
    func makeUIViewController(context: Context) -> UIViewControllerType {
        MainIOSKt.MainViewController()
    }
    
    func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context) {
        
    }
    
    
}
