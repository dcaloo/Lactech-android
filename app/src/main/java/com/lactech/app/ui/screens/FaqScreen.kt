package com.lactech.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lactech.app.data.FaqDataProvider
import com.lactech.app.ui.components.FaqAccordionCard
import com.lactech.app.ui.theme.AppBackground
import com.lactech.app.ui.theme.AppSurface
import com.lactech.app.ui.theme.CardBorderColor
import com.lactech.app.ui.theme.LactareAzul
import com.lactech.app.ui.theme.LactareAzulSecondary
import com.lactech.app.ui.theme.TextPrimary
import com.lactech.app.ui.theme.TextSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FaqScreen(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var searchQuery by remember { mutableStateOf("") }
    val expandedStates = remember {
        mutableStateMapOf<Int, Boolean>().apply {
            // Start with the first question open, matching the web page (collapseOne show)
            put(1, true)
        }
    }

    val filteredFaqs = remember(searchQuery) {
        if (searchQuery.isBlank()) {
            FaqDataProvider.faqList
        } else {
            val query = searchQuery.trim().lowercase()
            FaqDataProvider.faqList.filter {
                it.question.lowercase().contains(query) || it.answer.lowercase().contains(query)
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("FAQ") },
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
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(AppBackground)
            .padding(innerPadding)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(12.dp))

            // Title & Intro
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Perguntas Frequentes",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = LactareAzulSecondary,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Encontre respostas para as principais dúvidas sobre a doação de leite humano.",
                    fontSize = 14.sp,
                    color = TextSecondary,
                    textAlign = TextAlign.Center,
                    lineHeight = 20.sp
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Search Bar
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Buscar dúvida ou palavra-chave...", fontSize = 14.sp) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Buscar",
                        tint = LactareAzul
                    )
                },
                trailingIcon = {
                    if (searchQuery.isNotEmpty()) {
                        IconButton(onClick = { searchQuery = "" }) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = "Limpar busca",
                                tint = TextSecondary
                            )
                        }
                    }
                },
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = AppSurface,
                    unfocusedContainerColor = AppSurface,
                    focusedBorderColor = LactareAzul,
                    unfocusedBorderColor = CardBorderColor
                ),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Stats / Expand toggle row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${filteredFaqs.size} ${if (filteredFaqs.size == 1) "pergunta" else "perguntas"}",
                    fontSize = 12.sp,
                    color = TextSecondary,
                    fontWeight = FontWeight.Medium
                )

                TextButton(
                    onClick = {
                        val hasAnyOpen = expandedStates.values.any { it }
                        if (hasAnyOpen) {
                            expandedStates.clear()
                        } else {
                            filteredFaqs.forEach { expandedStates[it.id] = true }
                        }
                    }
                ) {
                    val hasAnyOpen = expandedStates.values.any { it }
                    Text(
                        text = if (hasAnyOpen) "Recolher todas" else "Expandir todas",
                        fontSize = 12.sp,
                        color = LactareAzul,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }

        if (filteredFaqs.isEmpty()) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 40.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = Icons.Default.HelpOutline,
                            contentDescription = null,
                            tint = TextSecondary.copy(alpha = 0.5f),
                            modifier = Modifier.size(48.dp)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Nenhuma pergunta encontrada.",
                            color = TextSecondary,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        } else {
            items(
                items = filteredFaqs,
                key = { it.id }
            ) { faq ->
                val isExpanded = expandedStates[faq.id] == true
                FaqAccordionCard(
                    faq = faq,
                    isExpanded = isExpanded,
                    onToggle = {
                        expandedStates[faq.id] = !isExpanded
                    }
                )
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
    }
}

