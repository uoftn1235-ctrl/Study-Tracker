package com.nada.studytracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nada.studytracker.ui.theme.StudyTrackerTheme

data class Topic(val title: String, val isDone: Boolean)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            StudyTrackerTheme {

                val fakeTopics = listOf(
                    Topic("Kotlin Basics", true),
                    Topic("Jetpack Compose UI", true),
                    Topic("LazyColumn Lists", true)
                )

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    TopicListScreen(
                        topics = fakeTopics,
                        modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun TopicListScreen(
    topics: List<Topic>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(topics) { topic ->
            TopicCard(
                title = topic.title,
                isDone = topic.isDone
            )
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
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .background(Color.Green)
            .padding(16.dp),

        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = title)

        Text(
            text = if (isDone) "Done" else "Not Done"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TopicListScreenPreview() {
    StudyTrackerTheme {

        val sampleList = listOf(
            Topic("Kotlin Variables", true),
            Topic("Jetpack Compose", true),
            Topic("LazyColumn", true)
        )

        TopicListScreen(topics = sampleList)
    }
}