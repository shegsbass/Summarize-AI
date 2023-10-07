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

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Profile,
        NavigationItem.History
    )
    var selectedItem by remember { mutableStateOf(0) }
    var currentRoute by remember { mutableStateOf(NavigationItem.Home.route) }

    items.forEachIndexed { index, navigationItem ->
        if (navigationItem.route == currentRoute) {
            selectedItem = index
        }
    }

    NavigationBar(
        containerColor = Color.White,
        tonalElevation = 2.dp
    ) {
        items.forEachIndexed { index, item ->
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
                    item.icon?.let { // Check if the icon is not null
                        Icon(it, contentDescription = item.title)
                    }
                       },
                label = {
                    Text(item.title)
                        },
                selected = selectedItem == index,
                onClick = {
                    if (item != NavigationItem.Profile) {
                        selectedItem = index
                        currentRoute = item.route
                        navController.navigate(item.route) {
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = true
                                }
                            }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
                }
            )
        }
    }
}