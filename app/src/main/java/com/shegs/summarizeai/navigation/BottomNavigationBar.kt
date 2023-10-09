package com.shegs.summarizeai.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Profile,
        NavigationItem.ResultScreen,
        NavigationItem.History,
    )

    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    // Only show the bottom nav bar when the current route is one of the bottom nav destinations
    val bottomBarDestination = items.any { it.route == currentRoute }

    if (bottomBarDestination) {
        NavigationBar(
            containerColor = Color.White,
            tonalElevation = 2.dp
        ) {
            items.forEach { screen ->
                val selected = screen.route == currentRoute
                NavigationBarItem(
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFF11775E),
                        unselectedIconColor = Color.Gray,
                        selectedTextColor = Color.Black,
                        indicatorColor = Color.White
                    ),
                    modifier = Modifier,
                    alwaysShowLabel = true,
                    icon = {
                        screen.icon?.let { // Check if the icon is not null
                            Icon(it, contentDescription = screen.title)
                        }
                    },
                    label = {
                        Text(screen.title ?: "")
                    },
                    selected = selected,
                    onClick = {
                        if (screen == NavigationItem.Home) {
                            // If it's the Home icon, navigate to the Home screen
                            navController.navigate(NavigationItem.Home.route) {
                                // Configure navigation options as needed
                            }
                        } else {
                            // Handle navigation for other items
                            navController.navigate(screen.route) {
                                // Configure navigation options as needed
                            }
                        }
                        /*navController.navigate(screen.route) {
                            popUpTo(NavigationItem.Home.route) {
                                saveState = true
                            }
                            // Handles instances when the destination is already at the top of the stack.
                            launchSingleTop = true
                            restoreState = true
                        }*/

                    }
                )
            }
        }
    }
}