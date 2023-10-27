package com.jorgealdana.textstyleexamples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jorgealdana.textstyleexamples.ui.theme.TextStyleExamplesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextStyleExamplesTheme {
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

@Composable
fun TextColor() {
    Text(text = "Hola este texto tiene color", style = TextStyle(color = Color.Green))
}

@Composable
fun TextBackgroundColor() {
    Text(
        text = "Text with background",
        style = TextStyle(color = Color.Green, background = Color.DarkGray)
    )
}

@Composable
fun TextWithShadow() {
    Text(
        text = "Text with Shadow",
        style = TextStyle(shadow = Shadow(Color.Green, offset = Offset(5f, 5f), blurRadius = 2f))
    )
}

@Composable
fun TextFontFamilyWithSize() {
    Text(
        text = "Text with font family",
        style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Cursive)
    )
}

@Composable
fun TextWithFontStyle() {
    Text(text = "Text With Font Style", style = TextStyle(fontStyle = FontStyle.Italic))
}

@Composable
fun SpaceHeight() {
    Spacer(modifier = Modifier.height(20.dp))
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    TextStyleExamplesTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                TextColor()
                SpaceHeight()
                TextBackgroundColor()
                SpaceHeight()
                TextWithShadow()
                SpaceHeight()
                TextFontFamilyWithSize()
                SpaceHeight()
                TextWithFontStyle()
            }
        }
    }
}