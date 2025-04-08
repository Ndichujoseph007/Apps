package com.example.ndichujoseph

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ndichujoseph.ui.theme.NDICHUJOSEPHTheme

@Composable
fun AddScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE0FFFF))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Add New Student.",
            style = TextStyle(
                textDecoration = TextDecoration.Underline,
                color = Color.Black,
                fontFamily = FontFamily.Cursive,
                fontSize = 25.sp,
                fontWeight = FontWeight.ExtraBold
            )
        )
        var fullname by remember { mutableStateOf("") }
        var age by remember { mutableStateOf("") }
        val courses = listOf("Fullstack", "Cybersecurity", "Datascience")
        val genders = listOf("Male", "Female", "Custom")
        OutlinedTextField(
            value = fullname,
            onValueChange = { fullname = it },
            label = { Text("Full Name") },
            singleLine=true,
            modifier = Modifier
                .padding()
                .fillMaxWidth()
        )
        Spacer(modifier=Modifier.height(3.dp))
        OutlinedTextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Age") },
            singleLine=true,
            modifier = Modifier
                .fillMaxWidth(),
            keyboardOptions=KeyboardOptions(keyboardType=KeyboardType.Number)

        )
        Spacer(modifier=Modifier.height(3.dp))
        Button(onClick={},
            modifier= Modifier
                .fillMaxWidth())
        {
            Text("Add Me")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddScreenPreview() {
    NDICHUJOSEPHTheme {
        AddScreen()
    }
}