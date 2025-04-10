@file:JvmName("LoginKt")

package com.example.ndichujoseph.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ndichujoseph.ui.theme.NDICHUJOSEPHTheme

@Composable
fun LoginPage(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var Phone by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Black, Color.Blue)
                )
            )
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        Text(
            text = "SIGN IN",
            style = MaterialTheme.typography.headlineLarge.copy(
                fontWeight = FontWeight.ExtraBold,
                fontSize = 26.sp,
                fontFamily=FontFamily.SansSerif,
                letterSpacing = 1.5.sp
            ),
            color = Color.Cyan,
            modifier = Modifier
                .padding()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Black, Color.Blue),
                    ),
                    shape = MaterialTheme.shapes.medium
                )
                .padding(16.dp)
                .shadow(8.dp)
        )

        // Stylish Username Input
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            leadingIcon = { Icon(Icons.Filled.Person, contentDescription = "Username", tint = Color.Cyan.copy(alpha = 0.7f)) },
            label = { Text("Username", color = Color.White.copy(alpha = 0.7f)) },
            placeholder = { Text("Enter your username", color = Color.White.copy(alpha = 0.5f)) },
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(12.dp) // Rounded corners
        )
        //stylish Phone Number
        OutlinedTextField(
            value = Phone,
            onValueChange = { Phone = it },
            leadingIcon = { Icon(Icons.Filled.Phone, contentDescription = "Username", tint = Color.Cyan.copy(alpha = 0.7f)) },
            label = { Text("Phone Number", color = Color.White.copy(alpha = 0.7f)) },
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
            leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "Password", tint = Color.Cyan.copy(alpha = 0.7f)) },
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
            onClick = {navController.navigate("Dashboard")},
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3498DB)),
            shape = RoundedCornerShape(28.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            Text(
                "Login",
                color = Color.White,
                style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            )
        }
        Spacer(modifier=Modifier.height(30.dp))
        TextButton(
            onClick={navController.navigate("Register")}
        ) {
            Text(
                "Don't have an account?Sign in.",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(35.dp),
                color = Color.Green
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    NDICHUJOSEPHTheme {
        val mockNavController=rememberNavController()
        LoginPage(navController=mockNavController)
    }
}