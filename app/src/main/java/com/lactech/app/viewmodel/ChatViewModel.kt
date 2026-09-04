package com.lactech.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lactech.app.data.ChatMessage
import com.lactech.app.data.MessageSender
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {

    private val _messages = MutableStateFlow<List<ChatMessage>>(emptyList())
    val messages: StateFlow<List<ChatMessage>> = _messages.asStateFlow()

    private val _isTyping = MutableStateFlow(false)
    val isTyping: StateFlow<Boolean> = _isTyping.asStateFlow()

    val quickQuestions = listOf(
        "Como doar?",
        "Onde doar?",
        "É gratuito?",
        "Como armazenar?",
        "Quem somos?"
    )

    init {
        // Initial welcome message from Lacty
        val welcomeMessage = ChatMessage(
            sender = MessageSender.BOT,
            text = "Olá! Sou o Lacty, seu assistente virtual do LacTech. Como posso ajudar você hoje com informações sobre a doação de leite humano?"
        )
        _messages.value = listOf(welcomeMessage)
    }

    fun sendMessage(userText: String) {
        val trimmed = userText.trim()
        if (trimmed.isEmpty()) return

        val userMessage = ChatMessage(
            sender = MessageSender.USER,
            text = trimmed
        )

        _messages.value = _messages.value + userMessage

        viewModelScope.launch {
            _isTyping.value = true
            delay(450) // Natural response time

            val replyText = generateBotReply(trimmed)
            val botMessage = ChatMessage(
                sender = MessageSender.BOT,
                text = replyText
            )

            _messages.value = _messages.value + botMessage
            _isTyping.value = false
        }
    }

    private fun generateBotReply(userInput: String): String {
        val query = userInput.lowercase().trim()

        return when {
            query.contains("como doar") || query.contains("quem pode") || query.contains("requisito") || query.contains("posso doar") -> {
                "Para doar leite materno, você deve estar saudável, amamentando e com excesso de leite. Não pode tomar medicamentos contraindicados para a amamentação."
            }
            query.contains("onde") || query.contains("local") || query.contains("banco") || query.contains("posto") || query.contains("cep") -> {
                "Você pode localizar o Banco de Leite mais próximo na aba FAQ ou consultando os postos de coleta da rede Lactare mais próximos da sua residência!"
            }
            query.contains("gratuito") || query.contains("paga") || query.contains("custo") || query.contains("valor") || query.contains("cobrado") || query.contains("grátis") -> {
                "A coleta de leite materno pelo programa Lactare é 100% gratuita e pode ser agendada para ser realizada diretamente na sua residência!"
            }
            query.contains("armazenar") || query.contains("armazenamento") || query.contains("pote") || query.contains("guardar") || query.contains("recipiente") || query.contains("vidro") -> {
                "O leite deve ser guardado em pote de vidro com tampa de plástico, devidamente esterilizado (fervido por 15 min), e mantido congelado até a coleta."
            }
            query.contains("lactech") || query.contains("lactare") || query.contains("quem somos") || query.contains("projeto") || query.contains("eurofarma") -> {
                "A Lactech é uma plataforma de apoio ao programa Lactare da Eurofarma, facilitando a doação de leite humano e ajudando a salvar vidas de bebês prematuros."
            }
            query.contains("ola") || query.contains("olá") || query.contains("oi") || query.contains("bom dia") || query.contains("boa tarde") || query.contains("boa noite") || query.contains("lacty") -> {
                "Olá! Estou aqui para tirar suas dúvidas sobre a doação de leite humano. O que você gostaria de saber hoje?"
            }
            query.contains("obrigad") || query.contains("valeu") || query.contains("tchau") || query.contains("ate logo") || query.contains("até logo") -> {
                "Por nada! Estamos juntos nessa causa tão nobre. Se precisar de algo mais, é só me chamar!"
            }
            query.contains("teste") || query.contains("qualidade") || query.contains("segurança") || query.contains("pasteuriz") -> {
                "Todo o leite doado passa por rigorosos testes físico-químicos e microbiológicos, além de pasteurização, garantindo 100% de segurança para os bebês."
            }
            query.contains("pouco leite") || query.contains("muito leite") || query.contains("quantidade") -> {
                "Não precisa produzir muito leite! Qualquer quantidade excedente faz a diferença. Um pote pode alimentar até 10 recém-nascidos internados por dia."
            }
            else -> {
                "Entendi! Para essa e outras dúvidas sobre doação de leite, recomendo também visitar a nossa aba de FAQ. Se precisar, você pode me perguntar sobre 'quem pode doar', 'onde doar' ou 'como armazenar'!"
            }
        }
    }

    fun clearChat() {
        val welcomeMessage = ChatMessage(
            sender = MessageSender.BOT,
            text = "Conversa reiniciada. Como posso ajudar você agora?"
        )
        _messages.value = listOf(welcomeMessage)
    }
}

