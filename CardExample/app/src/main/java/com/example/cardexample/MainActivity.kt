package com.example.cardexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cardexample.ui.theme.CardExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        CardWithMultiplesComposable()
                    }
                }
            }
        }
    }
}

@Composable
fun CardWithElevation() {
    val paddingModifier = Modifier.padding(10.dp)
    Card(
        border = BorderStroke(width = 0.5.dp, color = Color.DarkGray),
        modifier = paddingModifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Text(text = "Simple card with elevation", modifier = paddingModifier)
    }
}

@Composable
fun CardWithShape() {
    val paddingModifier = Modifier.padding(10.dp)
    Card(
        border = BorderStroke(width = 0.5.dp, color = Color.DarkGray),
        modifier = paddingModifier,
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 10.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(text = "Simple card with shape", modifier = paddingModifier)
    }
}

@Composable
fun CardWithMultiplesComposable() {
    val paddingModifier = Modifier.padding(10.dp)
    Card(
        modifier = paddingModifier.fillMaxWidth(1f),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 10.dp),
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White, contentColor = MaterialTheme.colorScheme.secondary)
    ) {
        Column(modifier = paddingModifier) {
            Text(modifier = paddingModifier, text = "Lorem ipsum dolor", style = TextStyle(fontWeight = FontWeight.Bold, fontFamily = FontFamily.SansSerif, fontSize = 24.sp))
            Text(modifier = paddingModifier, text = "Description")
            Button(modifier = paddingModifier, shape = RoundedCornerShape(5.dp), onClick = { /*TODO*/ }) {
                Text(text = "Enviar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CardExampleTheme {
        Column {
            CardWithElevation()
            CardWithShape()
            CardWithMultiplesComposable()
        }
    }
}