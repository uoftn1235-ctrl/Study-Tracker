package com.nada.studytracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MaterialTheme {
                Surface {
                    TopicCard(title = "Kotlin Basics", isDone = true)

                }
            }
        }
    }
}

@Composable
fun TopicCard(title: String, isDone: Boolean) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(color = Color.LightGray)
            .padding(16.dp),

        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text ="tittle")

        Text(text = if (isDone) "Done" else "Not Done")
    }
}