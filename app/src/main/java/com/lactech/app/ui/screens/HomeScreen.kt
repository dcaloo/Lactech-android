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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.QuestionAnswer
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lactech.app.data.ImpactDataProvider
import com.lactech.app.ui.components.AppTopBar
import com.lactech.app.ui.components.ImpactCard
import com.lactech.app.ui.components.LactyAvatar
import com.lactech.app.ui.theme.AppBackground
import com.lactech.app.ui.theme.AppSurface
import com.lactech.app.ui.theme.CardBorderColor
import com.lactech.app.ui.theme.DividerColor
import com.lactech.app.ui.theme.LactareAzul
import com.lactech.app.ui.theme.LactareAzulSecondary
import com.lactech.app.ui.theme.LactareLightBlue
import com.lactech.app.ui.theme.LactareNav
import com.lactech.app.ui.theme.LactarePage
import com.lactech.app.ui.theme.TextPrimary
import com.lactech.app.ui.theme.TextSecondary

@Composable
fun HomeScreen(
    onNavigateToFaq: () -> Unit,
    onNavigateToChatbot: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            AppTopBar(currentTitle = "Início")
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .background(AppBackground)
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(8.dp))

                // Hero Banner
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(containerColor = AppSurface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(LactareNav.copy(alpha = 0.45f), AppSurface)
                                )
                            )
                            .padding(20.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            LactyAvatar(size = 56.dp)

                            Spacer(modifier = Modifier.height(12.dp))

                            Text(
                                text = "Doação de Leite Humano",
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                color = LactareAzulSecondary,
                                textAlign = TextAlign.Center
                            )

                            Spacer(modifier = Modifier.height(6.dp))

                            Text(
                                text = "Pequenos gestos que salvam milhares de vidas de recém-nascidos internados em UTIs neonatais.",
                                fontSize = 14.sp,
                                color = TextSecondary,
                                textAlign = TextAlign.Center,
                                lineHeight = 20.sp
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                OutlinedButton(
                                    onClick = onNavigateToChatbot,
                                    modifier = Modifier.weight(1f),
                                    shape = RoundedCornerShape(10.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Chat,
                                        contentDescription = null,
                                        modifier = Modifier.size(16.dp),
                                        tint = LactareAzulSecondary
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text("Tirar Dúvidas", fontSize = 13.sp, color = LactareAzulSecondary)
                                }

                                OutlinedButton(
                                    onClick = onNavigateToFaq,
                                    modifier = Modifier.weight(1f),
                                    shape = RoundedCornerShape(10.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.QuestionAnswer,
                                        contentDescription = null,
                                        modifier = Modifier.size(16.dp),
                                        tint = LactareAzulSecondary
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text("Ver FAQ", fontSize = 13.sp, color = LactareAzulSecondary)
                                }
                            }
                        }
                    }
                }
            }

            // Section "O que é?"
            item {
                InfoSectionCard(
                    icon = Icons.Default.Favorite,
                    iconTint = Color(0xFFE11D48),
                    title = "O que é?",
                    description = "A doação de leite humano é um ato voluntário em que mulheres que estão amamentando doam seu excedente para alimentar bebês prematuros ou de baixo peso internados em UTIs neonatais. O leite é processado e pasteurizado em Bancos de Leite Humano, garantindo total segurança e nutrição para salvar vidas."
                )
            }

            // Section "Quem Somos?"
            item {
                InfoSectionCard(
                    icon = Icons.Default.Info,
                    iconTint = LactareAzul,
                    title = "Quem Somos?",
                    description = "A Lactech é um projeto desenvolvido em apoio à Lactare, iniciativa pioneira da Eurofarma voltada à doação de leite humano e ao cuidado com recém-nascidos que dependem desse alimento.\n\nNosso propósito é facilitar o acesso a informações confiáveis sobre a doação, explicando de forma simples quem pode doar, como funciona o processo e onde buscar atendimento."
                )
            }

            // Section Header "Impacto do programa Lactare"
            item {
                Column(
                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
                ) {
                    Text(
                        text = "Impacto do programa Lactare",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = LactareAzulSecondary
                    )
                    Text(
                        text = "Resultados reais construídos com solidariedade",
                        fontSize = 13.sp,
                        color = TextSecondary
                    )
                }
            }

            // 6 Impact Cards
            items(ImpactDataProvider.impactItems) { item ->
                ImpactCard(item = item)
            }

            // Footer Section
            item {
                Card(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = LactareLightBlue.copy(alpha = 0.5f))
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "A Lactech torna o processo de doação de leite mais fácil, rápido e prático.",
                            fontSize = 13.sp,
                            color = TextPrimary,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Medium
                        )

                        Spacer(modifier = Modifier.height(12.dp))
                        Divider(color = DividerColor)
                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = "© 2026 Lactech — Apoio ao programa Lactare",
                            fontSize = 11.sp,
                            color = TextSecondary
                        )
                        Text(
                            text = "Termos de uso e privacidade",
                            fontSize = 11.sp,
                            color = LactareAzul,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
private fun InfoSectionCard(
    icon: ImageVector,
    iconTint: Color,
    title: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = AppSurface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(18.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                        .background(iconTint.copy(alpha = 0.12f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = iconTint,
                        modifier = Modifier.size(20.dp)
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    color = LactareAzulSecondary
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = description,
                fontSize = 14.sp,
                color = TextSecondary,
                lineHeight = 22.sp
            )
        }
    }
}