package com.shegs.summarizeai.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shegs.summarizeai.ui.screens.HistoryScreen
import com.shegs.summarizeai.ui.screens.HomeScreen
import com.shegs.summarizeai.ui.screens.MainScreen
import com.shegs.summarizeai.ui.screens.ProfileScreen

@Composable
fun AppNavigations(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            HomeScreen()
        }
        composable(NavigationItem.History.route) {
            HistoryScreen()
        }
//        composable(NavigationItem.Profile.route) {
//            ProfileScreen()
//        }
    }
}