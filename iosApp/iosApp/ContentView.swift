import SwiftUI
import shared

struct ContentView: View {
    
	var body: some View {
        //AboutScreen()
        ArticlesScreen(viewModel: .init()) //instanciando o viewModel dentro do ArticlesScreen.
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
