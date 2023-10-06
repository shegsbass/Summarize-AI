package com.shegs.summarizeai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.shegs.summarizeai.ui.theme.SummarizeAITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SummarizeAITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

fun main(){
    val apiKey = " "

    val summarizationFunction = SummarizationFunction()

    val inputText = """
        I recently worked on a project that had a significant impact on the teams involved in the HNG internship (Mobile track).

Within the last 48 hours, I had the privilege of developing an Android Authentication Library using Kotlin. The motivation behind the library was simple: multiple teams were repeatedly building the same authentication logic. It only made sense to create a reusable library that could streamline this process for everyone. 

I harnessed the power of Kotlin to create a versatile Android authentication library that seamlessly communicates with the backend API. This library handles user authentication, token management, and all the intricacies that come with it.

To make the library easily accessible to all teams, I hosted it on JitPack. This decision simplified the integration process and ensured that updates and improvements were readily available to everyone.

The process of writing this module in Android Studio was a rewarding experience. I collaborated closely with team members to identify the common authentication requirements and fine-tuned the library accordingly. I also wrote well-detailed documentation on how to use the library on GitHub. It was a true testament to the power of teamwork and open communication. 

The most gratifying part of this journey was seeing the entire team adopt and integrate the library into their respective projects. Choi... It brought smiles to my face because I could see that the library streamlined the development process, reduced redundancy, and allowed the teams to focus on what truly matters: delivering exceptional user experiences.

Really, being a software developer is much more than just writing code; it's the art of solving problems and providing solutions.
    """

    summarizationFunction.summarizeText(apiKey, inputText)
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SummarizeAITheme {

    }
}