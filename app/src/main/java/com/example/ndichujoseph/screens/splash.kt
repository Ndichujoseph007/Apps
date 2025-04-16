package com.example.ndichujoseph.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ndichujoseph.R
import com.example.ndichujoseph.ui.theme.NDICHUJOSEPHTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    val alpha = remember { Animatable(0f) }
    LaunchedEffect(Unit) {
        alpha.animateTo(1f, animationSpec = tween(1000))
        delay(2000)
        alpha.animateTo(0f, animationSpec = tween(500))
        delay(500)
        navController.navigate("HomePage") {
            popUpTo("SplashScreen") { inclusive = true }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Black, Color.Blue)
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Logo at the top
            Image(
                painter = painterResource(id = R.drawable.logo4),
                contentDescription = "logo",
                modifier = Modifier
                    .size(170.dp)
                    .clip(CircleShape)
            )

            // Space between logo and text
            Spacer(modifier = Modifier.height(64.dp))

            // Text centered
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    "Hi! Welcome to NDICHU's App",
                    color = Color.Green,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.SansSerif,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.padding(horizontal = 74.dp)
                )
                Text(
                    "Your personalized experience awaits...",
                    color = Color.Cyan,
                    style = TextStyle(
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily.SansSerif,
                    ),
                    modifier = Modifier.padding(top = 8.dp) // Added top padding for spacing
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    NDICHUJOSEPHTheme {
        val mockNavController = rememberNavController()
        SplashScreen(navController = mockNavController)
    }
}