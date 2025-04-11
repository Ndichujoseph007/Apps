package com.example.ndichujoseph.screens


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

import com.example.ndichujoseph.ui.theme.NDICHUJOSEPHTheme

@Composable
fun AboutUs(){
    Scaffold(
        topBar={ TopBar("ABOUT US") }
    ){innerpadding->
        Box(
            modifier= Modifier
                .fillMaxSize()
                .padding(innerpadding)
        ){
        Text(text="Discover amazing features and enjoy your experience.",
            style = TextStyle(
                color=Color.Blue,
                fontFamily=FontFamily.Cursive,
                fontSize = 25.sp,
                fontWeight = FontWeight.ExtraBold,
                textAlign=Center
            )
        )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AboutUsPreview() {
    NDICHUJOSEPHTheme {
        AboutUs()
    }
}
