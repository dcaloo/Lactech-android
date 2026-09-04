package com.lactech.app.ui.navigation

sealed class Screen(
    val route: String,
    val title: String
) {
    object Home : Screen(
        route = "home",
        title = "Início"
    )

    object Faq : Screen(
        route = "faq",
        title = "FAQ"
    )

    object Chatbot : Screen(
        route = "chatbot",
        title = "Lacty Bot"
    )
}
