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

/**
 * NavController: responsável por controlar as transições entre as telas.
 * NavHost: define o container onde as telas serão exibidas e registra
 * as rotas disponíveis (Screen.Home, Screen.Faq, Screen.Chatbot).
 *
 * Navegação em pilha, igual ao padrão do material do curso: cada tela
 * chama navController.navigate("rota") para avançar e
 * navController.popBackStack() para voltar (botão na TopAppBar de cada tela).
 */
@Composable
fun AppNavGraph(
    navController: NavHostController = rememberNavController(),
    chatViewModel: ChatViewModel = viewModel()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onNavigateToFaq = {
                    navController.navigate(Screen.Faq.route)
                },
                onNavigateToChatbot = {
                    navController.navigate(Screen.Chatbot.route)
                }
            )
        }

        composable(Screen.Faq.route) {
            FaqScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(Screen.Chatbot.route) {
            ChatbotScreen(
                viewModel = chatViewModel,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
