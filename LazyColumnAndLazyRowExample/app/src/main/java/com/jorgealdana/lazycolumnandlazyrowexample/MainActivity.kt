package com.jorgealdana.lazycolumnandlazyrowexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jorgealdana.lazycolumnandlazyrowexample.ui.theme.LazyColumnAndLazyRowExampleTheme

class MainActivity : ComponentActivity() {

    private val countryList =
        mutableListOf("Colombia", "Venezuela", "Peru", "Argentina", "Brazil", "Uruguay")
    private val modifier = Modifier
        .background(color = Color.DarkGray)
        .fillMaxSize()
        .padding(10.dp)
    private val textStyle = TextStyle(color = Color.White, fontSize = 20.sp)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumnAndLazyRowExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ListListScopeSample()
                }
            }
        }
    }

    @Composable
    fun SimpleCountryList() {
        LazyColumn(modifier = modifier) {
            items(countryList) { country ->
                Text(text = country, style = textStyle)
            }
        }
    }

    @Composable
    fun ListListScopeSample() {
        LazyColumn {
            item {
                Text(text = "Header")
            }

            items(3) { index -> //Add 3 items
                Text(text = "First line items: ${index + 1}")
            }

            items(2) { index ->
                Text(text = "Second line items: ${index + 1}")
            }

            item {
                Text(text = "Footer")
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun Preview() {
        LazyColumnAndLazyRowExampleTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                //ListListScopeSample()
                SimpleCountryList()
            }
        }
    }
}