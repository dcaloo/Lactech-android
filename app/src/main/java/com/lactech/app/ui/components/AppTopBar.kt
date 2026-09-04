package com.lactech.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lactech.app.ui.theme.LactareAzul
import com.lactech.app.ui.theme.LactareAzulSecondary
import com.lactech.app.ui.theme.LactareNav

@Composable
fun AppTopBar(
    currentTitle: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .shadow(elevation = 4.dp),
        color = LactareNav
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(horizontal = 16.dp, vertical = 10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment."CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Logo & App Name
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .background(LactareAzul, shape = RoundedCornerShape(10.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.WaterDrop,
                            contentDescription = "LacTech",
                            tint = Color.White,
                            modifier = Modifier.size(22.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Column {
                        Text(
                            text = "LacTech",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = LactareAzulSecondary,
                            letterSpacing = (-0.5).sp
                        )
                        Text(
                            text = "Apoio ao programa Lactare",
                            fontWeight = FontWeight.Medium,
                            fontSize = 11.sp,
                            color = LactareAzul.copy(alpha = 0.8f)
                        )
                    }
                }

                // Current Screen Badge
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = LactareAzul.copy(alpha = 0.12f)
                ) {
                    Text(
                        text = currentTitle,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = LactareAzulSecondary
                    )
                }
            }
        }
    }
}

