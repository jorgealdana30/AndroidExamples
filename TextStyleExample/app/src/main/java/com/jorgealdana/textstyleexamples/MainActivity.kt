package com.jorgealdana.textstyleexamples

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextDecoration
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
                    Column(horizontalAlignment = Alignment.CenterHorizontally ,modifier = Modifier.fillMaxHeight().fillMaxWidth()) {
                        TextColor()
                        SpaceHeight()
                        TextBackgroundColor()
                        SpaceHeight()
                        TextWithShadow()
                        SpaceHeight()
                        TextFontFamilyWithSize()
                        SpaceHeight()
                        TextWithFontStyle()
                        SpaceHeight()
                        TextWithDecoration()
                        SpaceHeight()
                        TextHeadingStyle()
                    }
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
        style = TextStyle(fontSize = 30.sp, fontFamily = FontFamily.SansSerif)
    )
}

@Composable
fun TextWithFontStyle() {
    Text(text = "Text With Font Style", style = TextStyle(fontStyle = FontStyle.Italic))
}

@Composable
fun TextWithDecoration(){
    Text(text = "Text with Underline", style = TextStyle(textDecoration = TextDecoration.Underline))
    Text(text = "Text with LineThrough", style = TextStyle(textDecoration = TextDecoration.LineThrough))
    Text(text = "Text with Combined decorations", style = TextStyle(textDecoration = TextDecoration.combine(
        listOf(TextDecoration.LineThrough, TextDecoration.Underline)
    )))
}

@Composable
fun TextHeadingStyle(){
    Text(text = "Heading Large", style = MaterialTheme.typography.headlineLarge)
    Text(text = "Heading Medium", style = MaterialTheme.typography.headlineMedium)
    Text(text = "Heading Small", style = MaterialTheme.typography.headlineSmall)
    Text(text = "Body Large", style = MaterialTheme.typography.bodyLarge)
    Text(text = "Body Medium", style = MaterialTheme.typography.bodyMedium)
    Text(text = "Body Small", style = MaterialTheme.typography.bodySmall)

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
            Column(modifier = Modifier.fillMaxHeight().fillMaxWidth()) {
                TextColor()
                SpaceHeight()
                TextBackgroundColor()
                SpaceHeight()
                TextWithShadow()
                SpaceHeight()
                TextFontFamilyWithSize()
                SpaceHeight()
                TextWithFontStyle()
                SpaceHeight()
                TextWithDecoration()
                SpaceHeight()
                TextHeadingStyle()
            }
        }
    }
}