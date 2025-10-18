package com.example.rickandmortyapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    personsListContent: @Composable () -> Unit,
    personInfoContent: @Composable () -> Unit,
    filterScreenContent: @Composable () -> Unit,
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.PersonsList.route
    ) {
        composable(Screen.PersonsList.route) {
            personsListContent()
        }
        composable(Screen.PersonInfo.route) {
            personInfoContent()
        }
        composable(Screen.FilterScreen.route) {
            filterScreenContent()
        }
    }
}



