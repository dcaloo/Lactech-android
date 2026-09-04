package com.lactech.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lactech.app.data.ChatMessage
import com.lactech.app.data.MessageSender
import com.lactech.app.ui.theme.AppSurface
import com.lactech.app.ui.theme.CardBorderColor
import com.lactech.app.ui.theme.LactareAzulSecondary
import com.lactech.app.ui.theme.LactareChatUserBubble
import com.lactech.app.ui.theme.TextPrimary
import com.lactech.app.ui.theme.TextSecondary

@Composable
fun ChatMessageBubble(
    message: ChatMessage,
    modifier: Modifier = Modifier
) {
    val isUser = message.sender == MessageSender.USER

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = if (isUser) Arrangement.End else Arrangement.Start,
        verticalAlignment = Alignment.Bottom
    ) {
        if (!isUser) {
            LactyAvatar(
                size = 32.dp,
                modifier = Modifier.padding(end = 8.dp, bottom = 2.dp)
            )
        }

        Column(
            horizontalAlignment = if (isUser) Alignment.End else Alignment.Start
        ) {
            Surface(
                shape = RoundedCornerShape(
                    topStart = 16.dp,
                    topEnd = 16.dp,
                    bottomStart = if (isUser) 16.dp else 4.dp,
                    bottomEnd = if (isUser) 4.dp else 16.dp
                ),
                color = if (isUser) LactareChatUserBubble else AppSurface,
                modifier = Modifier
                    .widthIn(max = 280.dp)
                    .then(
                        if (!isUser) Modifier.border(1.dp, CardBorderColor, RoundedCornerShape(16.dp, 16.dp, 16.dp, 4.dp))
                        else Modifier
                    ),
                shadowElevation = 1.dp
            ) {
                Text(
                    text = message.text,
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
                    color = TextPrimary,
                    fontSize = 14.sp,
                    lineHeight = 20.sp
                )
            }

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = message.formattedTime,
                fontSize = 10.sp,
                color = TextSecondary.copy(alpha = 0.7f),
                modifier = Modifier.padding(horizontal = 4.dp)
            )
        }

        if (isUser) {
            Box(
                modifier = Modifier
                    .padding(start = 8.dp, bottom = 2.dp)
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(LactareAzulSecondary.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Usuário",
                    tint = LactareAzulSecondary,
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    }
}

