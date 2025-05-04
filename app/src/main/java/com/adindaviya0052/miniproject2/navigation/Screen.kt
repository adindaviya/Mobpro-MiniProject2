package com.adindaviya0052.miniproject2.navigation

sealed class Screen(val route: String) {
    data object Home: Screen("mainScreen")
}