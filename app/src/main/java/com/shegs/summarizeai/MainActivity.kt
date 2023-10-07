package com.shegs.summarizeai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.shegs.summarizeai.ui.screens.MainScreen
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
                    val navController = rememberNavController()
                    MainScreen(navController)
                }
            }
        }
    }
}

fun main(){
    val apiKey = ""

    val summarizationFunction = SummarizationFunction()

    val inputText = """
        The success of your business may depend on improving the satisfaction of your internal customers.

Now you will say Ajoke you have come again. Which one is internal customers again.

Every business have two types of customers,

The internal customer and external customer.

Now who are these people?

We are all very conscious about our external customers, they are the people that use our products or services.

But what about the internal customers?

These are your coworkers, team members, stakeholders and staff of our businesses. They're the backbone of our organizations, and satisfying them is an integral part of your sales strategy.

Here are some tips to satisfying Internal customers

1️⃣ Effective Communication: Open, honest, and transparent communication is very important. Encourage dialogue, active listening, and the freedom to express ideas and concerns.

2️⃣ Empowerment and Trust: Empower your employees with responsibilities and trust their judgment. When individuals feel trusted, they are motivated to perform their best.

3️⃣Respecting Their Office: Acknowledge and respect the workspace of your employees. Do not teach them how to do their jobs and also don't interfere in their space

4️⃣Recognition and Appreciation: Acknowledge hard work and achievements. A simple 'thank you' or public recognition can go a long way in boosting morale and job satisfaction.

5️⃣Professional Development: Invest in the growth of your employees. Offer training, workshops, and mentorship programs that enhance their skills and confidence. Also make them a part of your decision makers

6️⃣ Constructive Feedback: Provide feedback that is specific, constructive, and actionable. Employees need to know where they stand and how they can improve.

By nurturing a supportive, empowering, and respectful internal culture, your business can soar to new heights.

Which of these tips do you agree with, comment down below.

I am Ajoke Yusuf. Revealing the secrets and spilling the hard truth about retention . I am on a mission to transform businesses by building outstanding, strong customer-interfacing teams.
    """

    summarizationFunction.summarizeText(apiKey, inputText)
}
