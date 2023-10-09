package com.shegs.summarizeai.ui.screens.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shegs.summarizeai.R

@Composable
fun GradientButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape,
    textStyle: TextStyle = TextStyle(
        fontSize = 14.sp,
        color = Color.White,
        fontFamily = FontFamily(Font(R.font.inter_regular))
    ),
    text: String
) {
    val gradient = Brush.linearGradient(
        colors = listOf(Color(0xFF11775E),
            Color(0xFF2A7CC8)),
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(45.dp)
            .background(brush = gradient, shape = shape)
            .then(Modifier.clickable { onClick() })
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = textStyle
        )
    }
}

@Composable
fun GradientButtonPreview(
    text: String,
    onClick: () -> Unit
) {
    GradientButton(
        onClick = onClick,
        modifier = Modifier.fillMaxSize(),
        shape = MaterialTheme.shapes.medium,
        textStyle = TextStyle(fontSize = 20.sp, color = Color.White),
        text = text
    )
}

@Preview
@Composable
fun GradientButtonPreviewPreview() {
    GradientButtonPreview(
        text = "Preview Gradient Button",
        onClick = {
            // Handle button click
        }
    )
}