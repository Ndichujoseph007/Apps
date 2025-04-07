package com.example.ndichujoseph

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.ndichujoseph.ui.theme.NDICHUJOSEPHTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                    Greeting()
                    LoginPage()
                    Register()
            Schooldashboard()

                }
            }
        }

@Composable
fun Greeting() {
    Text(
        text = "Hello"
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NDICHUJOSEPHTheme {
        Greeting()
    }
}