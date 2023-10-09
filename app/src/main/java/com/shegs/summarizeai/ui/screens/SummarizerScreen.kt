package com.shegs.summarizeai.ui.screens

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.shegs.summarizeai.R
import com.shegs.summarizeai.navigation.TopAppBar
import com.shegs.summarizeai.ui.screens.common.GradientButton
import com.shegs.summarizeai.ui.screens.common.TitleText

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SummarizerScreen(navController: NavHostController) {
        TopAppBar(text = "Summarize", navController = navController)

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 34.dp),
                verticalArrangement = Arrangement.Center
            ) {
                SummarizerTitle()
                AiGreeting()
                TextInputSection()
                SummarizeButton(navController)
            }

}

@Composable
fun SummarizerTitle() {
    TitleText(text = "Text Summarizer")
}


@Composable
fun AiGreeting() {

    var visibility by remember { mutableStateOf(true) }
    val greetingText = "Hi, I can help you summarize."

    Row(
        modifier = Modifier
            .padding(top = 26.dp, bottom = 26.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.eclipse),
            contentDescription = "Edit Icon",
            modifier = Modifier
                .width(23.dp)
                .height(23.dp),
        )

        Spacer(modifier = Modifier.width(14.dp))

        Card(
            modifier = Modifier
                .width(242.dp)
                .height(45.dp),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFE2F9ED),
                contentColor = Color(0xFF000000)
            )
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = greetingText,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.inter_regular)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(start = 12.dp)
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInputSection(
    modifier: Modifier = Modifier
        .padding(bottom = 41.dp),
    shape: Shape = RoundedCornerShape(size = 10.dp),
    height: Int = 465,
) {

    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { newText ->
            text = newText
        },
        placeholder = {
            Text(
                text = "Original Text",
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                fontWeight = FontWeight(600)
            )
        },
        modifier = modifier
            .fillMaxWidth()
            .height(height.dp)
            .border(width = 1.dp, color = Color(0xFF11775E), shape = shape)
            .background(Color(0xFFF2F8F5))
            .padding(12.dp),
        textStyle = TextStyle(
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(R.font.inter_regular)),
            fontWeight = FontWeight(400)
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text
        ),
        keyboardActions = KeyboardActions(
            onDone = { /* Handle keyboard done action if needed */ }
        ),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            cursorColor = Color(0xFF11775E)
        )
    )
}

@Composable
fun SummarizeButton(navController: NavController) {
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
    ) {
        GradientButton(
            onClick = {
                    navController.navigate("resultScreen")
            },
            shape = RoundedCornerShape(10.dp),
            text = "Summarize"
        )
    }
}
