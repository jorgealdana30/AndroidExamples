package com.jorgealdana.lazycolumnandlazyrowexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.jorgealdana.lazycolumnandlazyrowexample.models.FruitModel
import com.jorgealdana.lazycolumnandlazyrowexample.ui.theme.LazyColumnAndLazyRowExampleTheme

class MainActivity : ComponentActivity() {

    private val countryList =
        mutableListOf("Colombia", "Venezuela", "Peru", "Argentina", "Brazil", "Uruguay")
    private val fruitsList = mutableListOf<FruitModel>()
    private val modifier = Modifier
        .fillMaxSize()
        .background(color = Color.DarkGray)
        .padding(10.dp)
    private val textStyle = TextStyle(color = Color.White, fontSize = 20.sp)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getFruits()
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

    private fun getFruits(){
        fruitsList.add(FruitModel("Apple", R.drawable.apple))
        fruitsList.add(FruitModel("Orange", R.drawable.orange))
        fruitsList.add(FruitModel("Banana", R.drawable.banana))
        fruitsList.add(FruitModel("Strawberry", R.drawable.strawberry))
        fruitsList.add(FruitModel("Mango", R.drawable.mango))
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

    @Composable
    fun ListRow(model: FruitModel) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Image(
                painter = painterResource(id = model.image), contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .padding(5.dp)
            )
            Text(
                text = model.name,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
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