@file:JvmName("LoginKt")

package com.example.ndichujoseph

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ndichujoseph.ui.theme.NDICHUJOSEPHTheme

@Composable
fun LoginPage() {
    // State for username, email, and password
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.DarkGray)
            .padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        // Title text
        Text(
            text = "LOGIN",
            color = Color.White,
            style = MaterialTheme.typography.titleLarge
        )

        // Username input with placeholder
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            placeholder = { Text("Enter your username") },
            modifier = Modifier
                .padding(vertical = 10.dp)
                .fillMaxWidth(),

        )

        // Password input with placeholder
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            placeholder = { Text("Enter your password") },
            modifier = Modifier
                .padding(vertical = 10.dp)
                .fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),

        )

        // Login button
        Button(
            onClick = {
                // Handle login logic here
                println("Username: $username, Password: $password")
            },
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
        ) {
            Text("Login", color = Color.White)
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