 package com.nada.studytracker
 import  android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
 import com.nada.studytracker.ui.theme.StudyTrackerTheme
 import androidx.activity.enableEdgeToEdge
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StudyTrackerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TopicCard(
                        title = "Kotlin Basics",
                        isDone = true,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TopicCard(
    title: String,
    isDone: Boolean,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.Green)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(text = title)
        Text(text = if (isDone) "Done" else "Not Done")
    }
}


@Preview(showBackground = true, name = "Done Topic")
@Composable
fun TopicCardDonePreview() {
    StudyTrackerTheme {
        TopicCard(title = "Jetpack Compose", isDone = true)
    }
}

@Preview(showBackground = true, name = "Not Done Topic")
@Composable
fun TopicCardNotDonePreview() {
    StudyTrackerTheme {
        TopicCard(title = "Room Database", isDone = false)
    }
}