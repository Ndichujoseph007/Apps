package com.example.ndichujoseph.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.TopAppBarColors
import com.example.ndichujoseph.ui.theme.NDICHUJOSEPHTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard(navController: NavController) {
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
        TopAppBar(
            title = { Text("Login", color = Color.Black)},
            actions = {
            },
            modifier = Modifier
                .fillMaxWidth()
                .border(12.dp, Color.Gray, shape = RoundedCornerShape(3.dp)),
        )
        Text(
            text = "School System Dashboard",
            style = TextStyle(
                color=Color.Cyan,
                fontFamily=FontFamily.SansSerif,
                fontSize = 25.sp,
                fontWeight = FontWeight.ExtraBold
            ),color = Color.Cyan,
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
        // Add more cards
        DashboardCard(
            title = "Students.",
            description = "Manage student records.",
            icon = Icons.Default.Person,
        )
        DashboardCard(
            title = "Teachers.",
            description = "Manage teacher information.",
            icon = Icons.Default.Face,
        )
        DashboardCard(
            title = "Grades.",
            description = "Manage Grades for students.",
            icon = Icons.Default.DateRange,
        )
        DashboardCard(
            title = "Classes.",
            description = "Manage students classes.",
            icon = Icons.Default.Face,
        )
        DashboardCard(
            title = "Departments.",
            description = "Manage  teachers departments.",
            icon = Icons.Default.Face,
        )

    }
}


@Composable
fun DashboardCard(
    title: String,
    description: String,
    icon: ImageVector
) {
    Card(
        modifier = Modifier
            .border(12.dp, Color.Gray, shape = RoundedCornerShape(24.dp))
            .fillMaxWidth()
            .padding(4.dp)
            .clickable { },
        colors=CardDefaults.cardColors(
            containerColor=Color.LightGray,
            contentColor=Color.Blue
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 16.dp)
            )
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun DashboardPreview() {
    NDICHUJOSEPHTheme {
        val mockNavController=rememberNavController()
        Dashboard(navController=mockNavController)
    }
}
