package com.lactech.app.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lactech.app.data.FaqItem
import com.lactech.app.ui.theme.AppSurface
import com.lactech.app.ui.theme.CardBorderColor
import com.lactech.app.ui.theme.DividerColor
import com.lactech.app.ui.theme.LactareAzul
import com.lactech.app.ui.theme.LactareAzulSecondary
import com.lactech.app.ui.theme.LactareLightBlue
import com.lactech.app.ui.theme.TextPrimary
import com.lactech.app.ui.theme.TextSecondary

@Composable
fun FaqAccordionCard(
    faq: FaqItem,
    isExpanded: Boolean,
    onToggle: () -> Unit,
    modifier: Modifier = Modifier
) {
    val rotationAngle by animateFloatAsState(
        targetValue = if (isExpanded) 180f else 0f,
        label = "arrowRotation"
    )

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onToggle
            ),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isExpanded) LactareLightBlue.copy(alpha = 0.5f) else AppSurface
        ),
        border = BorderStroke(
            width = if (isExpanded) 1.5.dp else 1.dp,
            color = if (isExpanded) LactareAzul.copy(alpha = 0.4f) else CardBorderColor
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = if (isExpanded) 3.dp else 1.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            // Header Row (Question + Arrow)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 14.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = faq.question,
                    modifier = Modifier.weight(1f),
                    color = if (isExpanded) LactareAzulSecondary else TextPrimary,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp,
                    lineHeight = 21.sp
                )

                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = if (isExpanded) "Recolher" else "Expandir",
                    tint = if (isExpanded) LactareAzul else TextSecondary,
                    modifier = Modifier
                        .rotate(rotationAngle)
                        .padding(start = 8.dp)
                )
            }

            // Expandable Answer Body
            AnimatedVisibility(
                visible = isExpanded,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Divider(
                        color = DividerColor,
                        thickness = 1.dp,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = faq.answer,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp),
                        color = TextSecondary,
                        fontSize = 14.sp,
                        lineHeight = 22.sp
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}

