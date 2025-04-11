package com.example.ndichujoseph.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(title: String) {
    CenterAlignedTopAppBar(
        title = { Text(title) },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Blue,
            titleContentColor = Color.Cyan),
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
}