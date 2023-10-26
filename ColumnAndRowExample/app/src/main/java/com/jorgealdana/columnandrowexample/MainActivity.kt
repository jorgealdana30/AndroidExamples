package com.jorgealdana.columnandrowexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import com.jorgealdana.columnandrowexample.ui.theme.ColumnAndRowExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColumnAndRowExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        SimpleRow()
                        Spacer(modifier = Modifier.height(Dp(30f)))
                        SimpleColumn()
                        Spacer(modifier = Modifier.height(Dp(30f)))
                        RowArrangement()
                        Spacer(modifier = Modifier.height(Dp(30f)))
                        ColumnArrangement()
                    }
                }
            }
        }
    }
}

@Composable
fun SimpleRow() {
    Text(text = "Simple Row Example", fontSize = 20.sp, fontWeight = FontWeight.Bold)
    Row {
        Text(text = "Bloke 1")
        Text(text = "Bloke 2")
        Text(text = "Bloke 3")
    }
}

@Composable
fun SimpleColumn() {
    Text(text = "Simple Column Example", fontSize = 20.sp, fontWeight = FontWeight.Bold)
    Column {
        Text(text = "Bloke 1", Modifier.background(Color.Red))
        Text(text = "Bloke 2", Modifier.background(Color.Blue))
        Text(text = "Bloke 3", Modifier.background(Color.Green))
    }
}

@Composable
fun RowArrangement() {
    Text(
        text = "Row with Alignment and Arrangement",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "Bloke 1")
        Text(text = "Bloke 2")
        Text(text = "Bloke 3")
    }
}

@Composable
fun ColumnArrangement() {
    Text(
        text = "Column with Alignment and Arrangement",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )
    Column(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color.Magenta),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.Start,
    ) {
        Text(text = "Bloke 1", Modifier.background(Color.Red))
        Text(text = "Bloke 2", Modifier.background(Color.Blue))
        Text(text = "Bloke 3", Modifier.background(Color.Green))
    }
}

