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
import com.google.gson.Gson

@Composable
fun SecondScreen(
    navController: NavController,
    getName: String,
    getAge: Int,
    getWeight: Float,
    getIsSingle: Boolean
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Second Screen", fontSize = 52.sp)

        Text(text = getName, fontSize = 20.sp)
        Text(text = getAge.toString(), fontSize = 20.sp)
        Text(text = getWeight.toString(), fontSize = 20.sp)
        Text(text = getIsSingle.toString(), fontSize = 20.sp)

        Button(onClick = {
            val lesson = Lessons("Software", "Kotlin", 10)
            val lessonJson = Gson().toJson(lesson)
            navController.navigate("thirdScreen/$lessonJson") {
                //back stack'ten silinecek sayfanın etiketi popUpTo içine yazılır.
                popUpTo("secondScreen") { inclusive = true }
            }
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