package com.example.ndichujoseph

import androidx.compose.foundation.Image
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.ndichujoseph.ui.theme.NDICHUJOSEPHTheme

@Composable
fun Register() {
    // State variables for user input
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Black, Color.Yellow)
                )
            )
            .padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        //Image(painter=painterResource(id=R.drawable.logo),contentDescription="logo")
        // Enhanced title text with styling
        Text(
            text = "REGISTER",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold,
                fontFamily =FontFamily.Cursive , 
                fontSize = 32.sp,
                letterSpacing = 1.5.sp
            ),
            color = Color.Cyan,
            modifier = Modifier
                .padding(bottom = 24.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Black, Color.Yellow),
                    ),
                    shape = MaterialTheme.shapes.medium
                )
                .padding(16.dp)
                .shadow(8.dp)
        )
        Spacer(modifier = Modifier.width(32.dp))

        // Username input field with placeholder
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            placeholder = { Text("Enter your username") },
            leadingIcon = {
                Icon(Icons.Filled.Person, contentDescription = "Username Icon", tint = Color.Cyan.copy(alpha = 0.7f))
            },
            modifier = Modifier
                .padding(vertical = 10.dp)
                .fillMaxWidth()

        )

        // Email input field with placeholder
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            placeholder = { Text("Enter your email") },
            leadingIcon = {
                Icon(Icons.Filled.Email, contentDescription = "Email Icon", tint = Color.Cyan.copy(alpha = 0.7f)) // Assuming you have a Lock icon
            },
            modifier = Modifier
                .padding(vertical = 10.dp)
                .fillMaxWidth()

        )

        // Password input field with placeholder and visual transformation to hide text
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            placeholder = { Text("Enter your password") },
            leadingIcon = {
                Icon(Icons.Filled.Lock, contentDescription = "Password Icon", tint = Color.Cyan.copy(alpha = 0.7f))
            },

            modifier = Modifier
                .padding(vertical = 10.dp)
                .fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )

        // Confirm Password input field with placeholder
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirm Password") },
            placeholder = { Text("Re-enter your password") },
            leadingIcon = {
                Icon(Icons.Filled.Lock, contentDescription = "Password Icon", tint = Color.Cyan.copy(alpha = 0.7f)) // Assuming you have a Lock icon
            },
            modifier = Modifier
                .padding(vertical = 10.dp)
                .fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )

        // Register button
        Button(
            onClick = {
                // Handle registration logic here
                println("Username: $username, Email: $email, Password: $password")
            },
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth()
        ) {
            Text("Register")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun RegisterPreview() {
    NDICHUJOSEPHTheme {
        Register()
    }
}