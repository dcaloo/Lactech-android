package com.lactech.app.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun LactyAvatar(
    modifier: Modifier = Modifier,
    size: Dp = 40.dp
) {
    Box(
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .background(Color(0xFFEAF7FF)),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.size(size * 0.85f)) {
            val w = this.size.width
            val h = this.size.height
            val scaleX = w / 64f
            val scaleY = h / 64f

            drawCircle(
                color = Color(0xFF38BDF8),
                radius = 4.5f * scaleX,
                center = Offset(32f * scaleX, 7f * scaleY)
            )
            drawCircle(
                color = Color.White,
                radius = 2.2f * scaleX,
                center = Offset(32f * scaleX, 7f * scaleY)
            )
            drawRoundRect(
                color = Color(0xFF0284C7),
                topLeft = Offset(30f * scaleX, 10f * scaleY),
                size = Size(4f * scaleX, 6f * scaleY),
                cornerRadius = CornerRadius(2f * scaleX, 2f * scaleY)
            )


            drawRoundRect(
                color = Color(0xFF0284C7),
                topLeft = Offset(6f * scaleX, 24f * scaleY),
                size = Size(6f * scaleX, 16f * scaleY),
                cornerRadius = CornerRadius(3f * scaleX, 3f * scaleY)
            )
            drawRoundRect(
                color = Color(0xFF0284C7),
                topLeft = Offset(52f * scaleX, 24f * scaleY),
                size = Size(6f * scaleX, 16f * scaleY),
                cornerRadius = CornerRadius(3f * scaleX, 3f * scaleY)
            )
            drawCircle(
                color = Color(0xFFBAE6FD),
                radius = 2f * scaleX,
                center = Offset(9f * scaleX, 32f * scaleY)
            )
            drawCircle(
                color = Color(0xFFBAE6FD),
                radius = 2f * scaleX,
                center = Offset(55f * scaleX, 32f * scaleY)
            )


            drawRoundRect(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFF38BDF8), Color(0xFF0284C7), Color(0xFF0369A1)),
                    start = Offset(0f, 0f),
                    end = Offset(w, h)
                ),
                topLeft = Offset(10f * scaleX, 15f * scaleY),
                size = Size(44f * scaleX, 37f * scaleY),
                cornerRadius = CornerRadius(14f * scaleX, 14f * scaleY)
            )


            drawRoundRect(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF0B1329), Color(0xFF1E293B)),
                    startY = 20f * scaleY,
                    endY = 47f * scaleY
                ),
                topLeft = Offset(15f * scaleX, 20f * scaleY),
                size = Size(34f * scaleX, 27f * scaleY),
                cornerRadius = CornerRadius(9f * scaleX, 9f * scaleY)
            )


            drawCircle(
                color = Color(0xFFF43F5E).copy(alpha = 0.75f),
                radius = 2.2f * scaleX,
                center = Offset(20f * scaleX, 38f * scaleY)
            )
            drawCircle(
                color = Color(0xFFF43F5E).copy(alpha = 0.75f),
                radius = 2.2f * scaleX,
                center = Offset(44f * scaleX, 38f * scaleY)
            )


            drawCircle(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFF67E8F9), Color(0xFF06B6D4))
                ),
                radius = 4f * scaleX,
                center = Offset(23f * scaleX, 30f * scaleY)
            )
            drawCircle(
                color = Color.White,
                radius = 1.3f * scaleX,
                center = Offset(24.5f * scaleX, 28.5f * scaleY)
            )


            drawCircle(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFF67E8F9), Color(0xFF06B6D4))
                ),
                radius = 4f * scaleX,
                center = Offset(41f * scaleX, 30f * scaleY)
            )
            drawCircle(
                color = Color.White,
                radius = 1.3f * scaleX,
                center = Offset(42.5f * scaleX, 28.5f * scaleY)
            )


            val smilePath = Path().apply {
                moveTo(27f * scaleX, 37f * scaleY)
                quadraticBezierTo(
                    32f * scaleX, 42.5f * scaleY,
                    37f * scaleX, 37f * scaleY
                )
            }
            drawPath(
                path = smilePath,
                color = Color(0xFF38BDF8),
                style = Stroke(width = 2.5f * scaleX, cap = StrokeCap.Round)
            )
        }
    }
}

