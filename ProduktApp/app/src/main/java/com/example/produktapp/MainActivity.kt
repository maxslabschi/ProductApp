package com.example.produktapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.produktapp.ui.screen.MainScreen
import com.example.produktapp.ui.screen.ProductScreen
import com.example.produktapp.ui.theme.ProduktAppTheme
import com.example.produktapp.viewmodel.ProductViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = viewModels<ProductViewModel> ().value
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                MainScreen()
            }
            /*
            ProduktAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    if(viewModel._productsAvailableState.value)
                        ProductScreen(viewModel = viewModel, modifier = Modifier.padding(innerPadding))
                    else
                        Greeting(name = "Maxi", modifier = Modifier.padding(innerPadding))
                }
            }

             */
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProduktAppTheme {
        Greeting("Android")
    }
}