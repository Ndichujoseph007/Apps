@file:JvmName("LoginKt")

package com.example.ndichujoseph

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ndichujoseph.ui.theme.NDICHUJOSEPHTheme

@Composable
fun LoginPage() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color =Color.LightGray)
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        //logo
        Image(painter=painterResource(id=R.drawable.logo),contentDescription="logo")
        // Stylish Title
        Text(
            text = "SIGN IN",
            color=Color.Cyan,
            style = MaterialTheme.typography.headlineLarge.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp,
                letterSpacing = 1.5.sp
            ),
            modifier = Modifier
                .padding(top=2.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.White, Color.White),
                    ),
                    shape = MaterialTheme.shapes.medium
                )
        )

        // Stylish Username Input
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            leadingIcon = { Icon(Icons.Filled.Person, contentDescription = "Username", tint = Color.Black.copy(alpha = 0.7f)) },
            label = { Text("Username", color = Color.White.copy(alpha = 0.7f)) },
            placeholder = { Text("Enter your username", color = Color.White.copy(alpha = 0.5f)) },
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(12.dp) // Rounded corners
        )

        // Stylish Password Input
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "Password", tint = Color.Black.copy(alpha = 0.7f)) },
            label = { Text("Password", color = Color.White.copy(alpha = 0.7f)) },
            placeholder = { Text("Enter your password", color = Color.White.copy(alpha = 0.5f)) },
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            shape = RoundedCornerShape(12.dp)
        )

        // Stylish Login Button
        Button(
            onClick = {
                println("Username: $username, Password: $password")
            },
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3498DB)),
            shape = RoundedCornerShape(8.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            Text(
                "Login",
                color = Color.White,
                style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    NDICHUJOSEPHTheme {
        LoginPage()
    }
}