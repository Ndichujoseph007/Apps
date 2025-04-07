package com.example.ndichujoseph

import android.R.attr.icon
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ndichujoseph.ui.theme.NDICHUJOSEPHTheme


@Composable
fun Schooldashboard(){
    Column(
        modifier= Modifier
            .fillMaxSize()
            .padding(50.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
       Text(
           text="School System Dashboard",
                   style = TextStyle(textDecoration = TextDecoration.Underline)
       )
        //add cards
        DashboardCard(
            title="Students",
            description="Manage students",
            icon= Icons.Default.Person
       )
    }
}

@Composable
fun DashboardCard(
    title:String,
    description:String,
    icon:ImageVector
) {
    Card(
        modifier= Modifier
            .fillMaxWidth()
            .clickable(),
        elevation= 8.dp
    ){
        Row(
            modifier= Modifier
                .padding(16.dp),
            verticalAlignment=Alignment.CenterVertically
        ){
           Icon(
               imageVector= icon,
               contentDescription=null,
               modifier= Modifier
                   .size(40.dp),
           )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SchooldashboardPreview() {
    NDICHUJOSEPHTheme {
        Schooldashboard()
    }
}