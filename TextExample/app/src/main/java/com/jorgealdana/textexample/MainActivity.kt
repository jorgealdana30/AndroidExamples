package com.jorgealdana.textexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.jorgealdana.textexample.ui.theme.TextExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        TextSize(text = "Text with size", size = 20.sp)
                        SpacerHeight(height = 20f)
                        TextColor()
                        SpacerHeight(height = 20f)
                        TextBold()
                        SpacerHeight(height = 20f)
                        TextItalic()
                        SpacerHeight(height = 20f)
                        TextMaxNumberLine()
                        SpacerHeight(height = 20f)
                        TextWithOverflow()
                        SpacerHeight(height = 20f)
                        TextWithSelection()
                    }
                }
            }
        }
    }
}

@Composable
fun SpacerHeight(height: Float) {
    Spacer(Modifier.height(Dp(height)))
}

@Composable
fun TextSize(text: String, size: TextUnit) {
    Text(text = text, fontSize = size)
}

@Composable
fun TextColor() {
    Text(text = "Text with Color", color = Color.Red)
}

@Composable
fun TextBold() {
    Text(text = "Text with Weight", fontWeight = FontWeight.ExtraBold)
}

@Composable
fun TextItalic() {
    Text(text = "Text with Italic style", fontStyle = FontStyle.Italic)
}

@Composable
fun TextMaxNumberLine() {
    Text(text = "Hello ".repeat(50), maxLines = 2)
}

@Composable
fun TextWithOverflow() {
    Text(text = "Overflow".repeat(50), maxLines = 1, overflow = TextOverflow.Ellipsis)
}

@Composable
fun TextWithSelection() {
    SelectionContainer {
        Text(text = "Try to select me!!")
    }
}

@Preview
@Composable
fun Review() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column {
            TextSize(text = "Text with size", size = 20.sp)
            SpacerHeight(height = 20f)
            TextColor()
            SpacerHeight(height = 20f)
            TextBold()
            SpacerHeight(height = 20f)
            TextItalic()
            SpacerHeight(height = 20f)
            TextMaxNumberLine()
            SpacerHeight(height = 20f)
            TextWithOverflow()
            SpacerHeight(height = 20f)
            TextWithSelection()
        }
    }
}