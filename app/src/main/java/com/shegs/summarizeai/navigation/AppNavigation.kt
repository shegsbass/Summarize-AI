package com.shegs.summarizeai.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shegs.summarizeai.ui.screens.HistoryScreen
import com.shegs.summarizeai.ui.screens.HomeScreen
import com.shegs.summarizeai.ui.screens.ResultScreen
import com.shegs.summarizeai.ui.screens.SummarizerScreen

@Composable
fun AppNavigation(navController: NavHostController) {




    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            HomeScreen(navController)
        }
        composable(NavigationItem.History.route) {
            HistoryScreen()
        }
        composable(NavigationItem.SummarizeScreen.route){
            SummarizerScreen(navController)
        }
        composable(NavigationItem.ResultScreen.route){
            ResultScreen()
        }
//        composable(NavigationItem.Profile.route) {
//            ProfileScreen()
//        }
    }
}

