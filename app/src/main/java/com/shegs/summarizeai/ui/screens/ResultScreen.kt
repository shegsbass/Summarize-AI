package com.shegs.summarizeai.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.shegs.summarizeai.R
import com.shegs.summarizeai.navigation.BottomNavigationBar
import com.shegs.summarizeai.navigation.TopAppBar
import com.shegs.summarizeai.ui.screens.common.GradientButton
import com.shegs.summarizeai.ui.screens.common.TitleText


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultScreen(navController: NavHostController) {
    TopAppBar(text = "Result", navController = navController)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 34.dp),
        verticalArrangement = Arrangement.Center
    ) {
        ResultTitle()
        SubTitle()
        ResultSection()
        ActionButtons()
    }
}


@Composable
fun ResultTitle() {
    TitleText(text = "We have your\nresult here")
}

@Composable
fun SubTitle() {
    Column(
        modifier = Modifier
            .padding(bottom = 19.dp, top = 31.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = "Summarized Text",
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.inter_bold)),
                fontWeight = FontWeight(600),
                color = Color(0xFF000000),
            )
        )
    }
}

@Composable
fun ResultSection() {
    Column(
        modifier = Modifier
            .padding(bottom = 104.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(326.dp),
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(1.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFE2F9ED),
                contentColor = Color(0xFF000000)
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 18.dp),
                contentAlignment = Alignment.TopStart
            ) {
                Text(
                    text = "This is just to check the height of the card",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.inter_regular)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),
                    ),
                    modifier = Modifier
                        .padding(start = 12.dp)
                )
            }
        }
    }
}

@Composable
fun ActionButtons() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        GradientButton(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(10.dp),
            text = "Save",
            modifier = Modifier
                .width(104.dp)
        )

        Spacer(modifier = Modifier.width(14.dp))

        GradientButton(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(10.dp),
            imageVector = Icons.Default.Share,
            tint = Color.White,
            modifier = Modifier
                .width(48.dp)
        )
    }
}