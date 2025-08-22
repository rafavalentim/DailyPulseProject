package com.rafael.dailypulse.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import com.rafael.dailypulse.Platform
import com.rafael.dailypulse.articles.presentation.ArticlesViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Platform().logSystemInfo()
        //val articlesViewModel : ArticlesViewModel by viewModels()

        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //AboutScreen()
                    //ArticlesScreen(articlesViewModel = articlesViewModel)
                    AppScaffold()
                }
            }
        }
    }
}


//@Preview
//@Composable
//fun DefaultPreview() {
//    MyApplicationTheme {
//        AboutScreen()
//    }
//}
