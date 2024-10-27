package com.umairrasheed.showpdffromassets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.umairrasheed.showpdffromassets.ui.theme.ShowPdfFromAssetsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShowPdfFromAssetsTheme {
                App()
            }
        }
    }

    @Composable
    fun App() {

        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "home") {

            composable(route = "home") {
                HomeScreen {
                    navController.navigate("show_pdf")
                }
            }

            composable(route = "show_pdf") {
                ShowPdfScreen()
            }

        }

    }

}