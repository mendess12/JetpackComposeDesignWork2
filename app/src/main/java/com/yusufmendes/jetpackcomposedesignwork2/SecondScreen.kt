package com.yusufmendes.jetpackcomposedesignwork2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SecondScreen(navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Second Screen", fontSize = 52.sp)

        Button(onClick = {
            navController.navigate("thirdScreen")
        }) {
            Text(text = "Go to Third Screen")
        }

        Button(onClick = {
            navController.popBackStack()
        }) {
            Text(text = "Back to Main Screen")
        }
    }
}