package com.lactech.app.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DeleteOutline
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lactech.app.ui.components.ChatMessageBubble
import com.lactech.app.ui.components.LactyAvatar
import com.lactech.app.ui.theme.AppBackground
import com.lactech.app.ui.theme.AppSurface
import com.lactech.app.ui.theme.CardBorderColor
import com.lactech.app.ui.theme.DividerColor
import com.lactech.app.ui.theme.LactareAzul
import com.lactech.app.ui.theme.LactareAzulSecondary
import com.lactech.app.ui.theme.LactareLightBlue
import com.lactech.app.ui.theme.TextPrimary
import com.lactech.app.ui.theme.TextSecondary
import com.lactech.app.viewmodel.ChatViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatbotScreen(
    viewModel: ChatViewModel,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val messages by viewModel.messages.collectAsState()
    val isTyping by viewModel.isTyping.collectAsState()
    var inputMessage by remember { mutableStateOf("") }
    val listState = rememberLazyListState()

    // Auto-scroll to bottom when new messages arrive or when bot starts typing
    LaunchedEffect(messages.size, isTyping) {
        if (messages.isNotEmpty()) {
            listState.animateScrollToItem(messages.size - 1)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Lacty Bot") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(AppBackground)
            .imePadding()
    ) {
        // Chatbot Header Card
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = AppSurface,
            shadowElevation = 2.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    LactyAvatar(size = 40.dp)

                    Spacer(modifier = Modifier.width(10.dp))

                    Column {
                        Text(
                            text = "Lacty",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = LactareAzulSecondary
                        )
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(8.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFF22C55E))
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = "Assistente Virtual Online",
                                fontSize = 11.sp,
                                color = TextSecondary
                            )
                        }
                    }
                }

                IconButton(
                    onClick = { viewModel.clearChat() }
                ) {
                    Icon(
                        imageVector = Icons.Default.DeleteOutline,
                        contentDescription = "Limpar conversa",
                        tint = TextSecondary
                    )
                }
            }
        }

        // Quick Suggestion Chips Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(AppSurface.copy(alpha = 0.8f))
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 12.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            viewModel.quickQuestions.forEach { question ->
                SuggestionChip(
                    text = question,
                    onClick = { viewModel.sendMessage(question) }
                )
            }
        }

        Divider(color = DividerColor, thickness = 1.dp)

        // Chat Messages List
        LazyColumn(
            state = listState,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            contentPadding = PaddingValues(vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(
                items = messages,
                key = { it.id }
            ) { message ->
                ChatMessageBubble(message = message)
            }

            if (isTyping) {
                item {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(start = 40.dp, top = 4.dp, bottom = 4.dp)
                    ) {
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = LactareLightBlue,
                            border = androidx.compose.foundation.BorderStroke(1.dp, CardBorderColor)
                        ) {
                            Text(
                                text = "Lacty está digitando...",
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                                fontSize = 12.sp,
                                color = LactareAzulSecondary,
                                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
                            )
                        }
                    }
                }
            }
        }

        // Input Field & Send Button
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = AppSurface,
            shadowElevation = 8.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = inputMessage,
                    onValueChange = { inputMessage = it },
                    placeholder = { Text("Digite a sua mensagem...", fontSize = 14.sp) },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(24.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = AppBackground,
                        unfocusedContainerColor = AppBackground,
                        focusedBorderColor = LactareAzul,
                        unfocusedBorderColor = CardBorderColor
                    ),
                    maxLines = 3
                )

                Spacer(modifier = Modifier.width(8.dp))

                IconButton(
                    onClick = {
                        if (inputMessage.isNotBlank()) {
                            viewModel.sendMessage(inputMessage)
                            inputMessage = ""
                        }
                    },
                    modifier = Modifier
                        .size(46.dp)
                        .clip(CircleShape)
                        .background(if (inputMessage.isNotBlank()) LactareAzul else LactareAzul.copy(alpha = 0.5f))
                ) {
                    Icon(
                        imageVector = Icons.Default.Send,
                        contentDescription = "Enviar",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
    }
}

@Composable
private fun SuggestionChip(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(16.dp),
        color = LactareLightBlue,
        border = androidx.compose.foundation.BorderStroke(1.dp, CardBorderColor)
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
            fontSize = 12.sp,
            color = LactareAzulSecondary,
            fontWeight = FontWeight.Medium
        )
    }
}

