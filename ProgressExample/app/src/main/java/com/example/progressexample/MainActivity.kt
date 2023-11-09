package com.example.progressexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.progressexample.ui.theme.ProgressExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProgressExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(Modifier.fillMaxWidth()) {
                        LinearProgressIndicator(
                            modifier = Modifier
                                .padding(10.dp)
                                .fillMaxWidth(),
                            trackColor = Color.LightGray,
                            color = Color.Red
                        )
                        LinearProgressIndicator(
                            progress = 0.6f, modifier = Modifier
                                .padding(10.dp)
                                .fillMaxWidth(),
                            trackColor = Color.LightGray,
                            color = Color.Red
                        )
                        CircularProgressIndicator(
                            modifier = Modifier
                                .padding(10.dp),
                            color = Color.Red,
                            strokeWidth = 2.dp
                        )
                        CircularProgressIndicator(
                            progress = 0.4f,
                            modifier = Modifier
                                .padding(10.dp),
                            color = Color.Red,
                            strokeWidth = 2.dp
                        )

                        CircularProgressWithAnimation()
                    }
                }
            }
        }
    }
}

@Composable
fun CircularProgressWithAnimation() {
    val progress = 0.75f
    val infiniteTransition = rememberInfiniteTransition(label = "transition")

    val progressValue by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = progress,
        animationSpec = infiniteRepeatable(animation = tween(900)), label = ""
    )
    CircularProgressIndicator(
        progress = progressValue,
        modifier = Modifier
            .padding(10.dp),
        color = Color.Red,
        strokeWidth = 2.dp
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProgressExampleTheme {
        LinearProgressIndicator(modifier = Modifier.padding(10.dp))
    }
}