package com.example.ndichujoseph.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ndichujoseph.ui.theme.NDICHUJOSEPHTheme

@Composable
fun AddScreen(navController: NavController) {
    var fullname by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var selectedCourse by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Black, Color.Blue)
                )
            )
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Add New Student",
            style = MaterialTheme.typography.headlineMedium.copy(

                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
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
        )

        OutlinedTextField(
            value = fullname,
            onValueChange = { fullname = it },
            label = { Text("Full Name") },
            singleLine = true,
            modifier = Modifier
                .padding()
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(3.dp))
        OutlinedTextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Age") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        )
        Spacer(modifier = Modifier.height(3.dp))
        //course DropDownMenu
        DropDownMenuComponent(
            label = "Select Course",
            options = listOf("FULLSTACK", "CYBERSECURITY", "DATASCIENCE"),
            selectedOption = selectedCourse,
            onOptionSelected = { selectedCourse = it }
        )
        DropDownMenuComponent(
            label = "Select Gender",
            options = listOf("MALE", "FEMALE", "CUSTOM"),
            selectedOption = selectedGender,
            onOptionSelected = { selectedGender = it }
        )

        Button(
            onClick = {
                println("Adding student with name: $fullname, age: $age, course: $selectedCourse")
            },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3498DB)),
            shape = RoundedCornerShape(28.dp)
        ) {
            Text(
                "Add Student",
                color = Color.White,
                style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            )
        }
    }
}



@Composable
fun DropDownMenuComponent(
    label: String,
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }
    OutlinedTextField(
        value = selectedOption,
        onValueChange = {},
        readOnly = true,
        label = { Text(label) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 2.dp),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = null,
                modifier = Modifier
                    .clickable { expanded = !expanded }
            )
        }
    )
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false }
    ) {
        options.forEach { option ->
            DropdownMenuItem(
                text = { Text(option) },
                onClick = {
                    onOptionSelected(option)
                    expanded = false
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddScreenPreview() {
    NDICHUJOSEPHTheme {
        val mockNavController=rememberNavController()
        AddScreen(navController=mockNavController)
    }
}