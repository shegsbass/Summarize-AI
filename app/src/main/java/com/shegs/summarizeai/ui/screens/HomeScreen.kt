package com.shegs.summarizeai.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.shegs.summarizeai.R

@Composable
fun HomeScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        HeadingText()
        IntroText()
        ImageSection()
        SummariseBox(navController)
    }
}


@Composable
fun HeadingText(){
    Box(
        modifier = Modifier
            .padding(bottom = 9.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Sumarice",
            style = TextStyle(
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                fontWeight = FontWeight(500),
                color = Color(0xFF000000),
            )
        )
    }

}

@Composable
fun IntroText() {
    Box(
        modifier = Modifier
            .padding(start = 70.dp, end = 70.dp, bottom = 21.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Summarise your long copy, text, or book with Somarice",
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.inter_regular)),
                fontWeight = FontWeight(400),
                color = Color(0x99000000),
            ),
            textAlign = TextAlign.Center,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun ImageSection() {
    Box(
        modifier = Modifier
            .padding(start = 67.dp, end = 67.dp, bottom = 7.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.sumarice_image),
            contentDescription = "Sumarice image avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(226.dp)
                .height(231.dp)
        )
    }
}

@Composable
fun SummariseBox(navController: NavController) {
    Box(
        modifier = Modifier
            .width(252.dp)
            .height(173.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF11775E),
                        Color(0xFF2A7CC8)
                    )
                ),
                shape = RoundedCornerShape(20.dp) // Apply corner radius to the shape
            )
            .clickable { // Make the Box clickable
                // Navigate to the new screen when the Box is clicked
                navController.navigate("summarizeScreen") // Replace "destinationScreen" with the actual destination route
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(id = R.drawable.edit_icon),
                contentDescription = "Edit Icon",
                modifier = Modifier
                    .width(64.dp)
                    .height(64.dp)
                    .padding(bottom = 27.dp)
            )

            Text(
                text = "Begin Summarizing",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.inter_regular)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFFFFFFFF),
                ),
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

        }

    }
}