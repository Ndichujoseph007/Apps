package com.example.ndichujoseph.screens

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ndichujoseph.ViewModel.AuthViewModel
import com.example.ndichujoseph.ui.theme.NDICHUJOSEPHTheme

@Composable
fun Register(
    navController: NavController,
    viewModel: AuthViewModel
) {
    // State variables for user input
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    val isRegistered=viewModel.isRegistered
    LaunchedEffect(isRegistered){
        if(isRegistered==true){
            navController.navigate(("dashboard")){
                popUpTo("Register")
                {inclusive=true}
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.White, Color.Blue)
                )
            )
            .padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        //Image(painter=painterResource(id=R.drawable.logo),contentDescription="logo")
        // Enhanced title text with styling
        Text(
            text = "SIGN UP",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold,
                fontFamily =FontFamily.SansSerif ,
                fontSize = 32.sp,
                letterSpacing = 1.5.sp
            ),
            color = Color.Cyan,
            modifier = Modifier
                .padding(bottom = 24.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Black, Color.Blue),
                    ),
                    shape = MaterialTheme.shapes.medium
                )
                .padding(16.dp)
                .shadow(8.dp)
                .clip(CircleShape)
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
            singleLine = true,
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
            singleLine = true,
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
            singleLine = true,
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
                if(password == confirmPassword && email.isNotBlank() && password.isNotBlank()
                    ){
                    viewModel.register(email,password)
                    navController.navigate("Dashboard")
                }
                else{
                    println("Passwords do not match or fields are empty")
                }
            },
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3498DB)),
            shape = RoundedCornerShape(28.dp),
        ) {
            Text("Register",
            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.SemiBold))
        }
        Spacer(modifier=Modifier.height(30.dp))
        TextButton(
            onClick={navController.navigate("LoginPage")}) {
            Text(
                "Already have an account?Login",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                color = Color.Green
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun RegisterPreview() {
    NDICHUJOSEPHTheme {
        val mockNavController=rememberNavController()
        val mockViewModel= AuthViewModel()
        Register(navController=mockNavController,viewModel=mockViewModel)
    }
}