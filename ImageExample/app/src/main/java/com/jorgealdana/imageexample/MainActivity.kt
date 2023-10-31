package com.jorgealdana.imageexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jorgealdana.imageexample.ui.theme.ImageExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImageExampleTheme {
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
fun SimpleImage() {
    Image(
        painter = painterResource(id = R.drawable.burro),
        contentDescription = "Burro image",
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun CircleImage() {
    Image(
        painter = painterResource(id = R.drawable.burro), contentDescription = "Burro image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(128.dp)
            .clip(CircleShape)
            .border(3.dp, Color.Black, CircleShape)
    )
}

@Composable
fun RoundCornerImage() {
    Image(
        painter = painterResource(id = R.drawable.burro), contentDescription = "Burro Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(128.dp)
            .clip(RoundedCornerShape(10.dp))
            .border(2.dp, Color.Red, RoundedCornerShape(10.dp))
    )
}

@Composable
fun ImageWithBackgroundColor() {
    Image(
        painter = painterResource(id = R.drawable.ic_cart), contentDescription = "Cart",
        Modifier
            .size(200.dp)
            .background(Color.Magenta)
            .padding(20.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    ImageExampleTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                SimpleImage()
                CircleImage()
                RoundCornerImage()
                ImageWithBackgroundColor()
            }
        }
    }
}