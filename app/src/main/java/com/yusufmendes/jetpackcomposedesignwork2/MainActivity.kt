package com.yusufmendes.jetpackcomposedesignwork2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.yusufmendes.jetpackcomposedesignwork2.ui.theme.JetpackComposeDesignWork2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeDesignWork2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PageTransitions()
                }
            }
        }
    }
}

//startDestination ilk açılacak sayfa
@Composable
fun PageTransitions() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "mainScreen") {
        composable("mainScreen") {
            MainScreen(navController = navController)
        }
        composable(
            "secondScreen/{name}/{age}/{weight}/{isSingle}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("age") { type = NavType.IntType },
                navArgument("weight") { type = NavType.FloatType },
                navArgument("isSingle") { type = NavType.BoolType },
            )
        ) {
            val name = it.arguments?.getString("name")!!
            val age = it.arguments?.getInt("age")!!
            val weight = it.arguments?.getFloat("weight")!!
            val isSingle = it.arguments?.getBoolean("isSingle")!!
            SecondScreen(navController = navController, name, age, weight, isSingle)
        }
        composable("thirdScreen/{object}",
            arguments = listOf(
                navArgument("object") { type = NavType.StringType }
            )
        ) {
            val json = it.arguments?.getString("object")
            val lessonObject = Gson().fromJson(json, Lessons::class.java)
            ThirdScreen(getLessons = lessonObject)
        }
    }
}

@Composable
fun MainScreen(navController: NavController) {

    val number = remember { mutableStateOf(10) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Main Screen", fontSize = 52.sp)

        Button(onClick = {
            navController.navigate("secondScreen/Yusuf/23/1.78f/true")
        }) {
            Text(text = "Go to Second Screen")
        }

        Text(text = "Number : ${number.value}")

        Button(onClick = { number.value = number.value + 2 }) {
            Text(text = "Click")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeDesignWork2Theme {
        PageTransitions()
    }
}