package com.example.ndichujoseph.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ndichujoseph.R
import com.example.ndichujoseph.ui.theme.NDICHUJOSEPHTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){
    LaunchedEffect(Unit){
        delay(3000)
        navController.navigate("HomePage"){
            popUpTo("SplashScreen"){inclusive=true}
        }
    }
    Box(
        modifier= Modifier
            .fillMaxSize()
            .background(color=Color.Black),
        contentAlignment=Alignment.Center
    ){
        Spacer(modifier= Modifier.height(50.dp))
        Image(
            painter = painterResource(id = R.drawable.logo6),
            contentDescription="logo",
            modifier = Modifier
                .size(170.dp)
                .padding(top=0.dp,bottom=2.dp)
                .clip(RoundedCornerShape(4000.dp)),
            contentScale = ContentScale.Crop
        )

        Column(){

            Spacer(modifier= Modifier.height(300.dp))

            Text("Hi!Welcome to NDICHU's App",
                color = Color.Cyan,
                style = TextStyle(fontSize =20.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.Cursive,
                    textAlign=Center
                ),modifier = Modifier
                        .padding(74.dp)
            )
            Spacer(modifier= Modifier.height(25.dp))



        }
    }
}


@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    NDICHUJOSEPHTheme {
        val mockNavController=rememberNavController()
        SplashScreen(navController=mockNavController)
    }
}