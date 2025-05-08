package com.adindaviya0052.miniproject2.navigation

import com.adindaviya0052.miniproject2.ui.screen.KEY_ID_FILM

sealed class Screen(val route: String) {
    data object Home: Screen("mainScreen")
    data object FormBaru: Screen("detailScreen")
    data object FormUbah: Screen("detailScreen/{$KEY_ID_FILM}") {
        fun withId(id: Long) = "detailScreen/$id"
    }
    data object Recycle: Screen("recycleScreen")
}