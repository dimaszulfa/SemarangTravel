package com.arcquila.semarangtravel.ui.navigation

import com.arcquila.semarangtravel.data.constant.Const

sealed class Screen(val route: String) {
    object Detail : Screen(Const.Cons.DETAIL) {
        fun createRoute(tourismId: Int) = "home/$tourismId"
    }
    object Home : Screen(Const.Cons.HOME)
    object AboutMe : Screen(Const.Cons.ABOUT)

}
