package com.lactech.app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lactech.app.ui.screens.ChatbotScreen
import com.lactech.app.ui.screens.FaqScreen
import com.lactech.app.ui.screens.HomeScreen
import com.lactech.app.viewmodel.ChatViewModel

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
    chatViewModel: ChatViewModel = viewModel()
) {
    NavHost(
        navController = navController,
        startDestination = HomeRoute
    ) {
        composable<HomeRoute> {
            HomeScreen(
                onNavigateToFaq = {
                    navController.navigate(FaqRoute)
                },
                onNavigateToChatbot = {
                    navController.navigate(ChatbotRoute)
                }
            )
        }

        composable<FaqRoute> {
            FaqScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable<ChatbotRoute> {
            ChatbotScreen(
                viewModel = chatViewModel,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}