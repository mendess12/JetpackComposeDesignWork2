package com.yusufmendes.jetpackcomposedesignwork2

import android.app.Activity
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp

@Composable
fun ThirdScreen(
    getLessons: Lessons
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Third Screen", fontSize = 52.sp)

        Text(text = getLessons.name, fontSize = 20.sp)
        Text(text = getLessons.language, fontSize = 20.sp)
        Text(text = getLessons.time.toString(), fontSize = 20.sp)
    }

    //Geri tuşuna basılınca activity'i kapatma işlemi
    val activity = (LocalContext.current as Activity)
    BackHandler(onBack = {
        Log.e("ThirdScreen", "Clicked back button")
        activity.finish()
    })
}