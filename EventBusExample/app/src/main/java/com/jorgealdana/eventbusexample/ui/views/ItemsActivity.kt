package com.jorgealdana.eventbusexample.ui.views

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.jorgealdana.eventbusexample.classes.CartEvent
import com.jorgealdana.eventbusexample.ui.views.ui.theme.EventBusExampleTheme
import org.greenrobot.eventbus.EventBus

class ItemsActivity : ComponentActivity(), OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EventBusExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ShowItems(this)
                }
            }
        }
    }

    override fun onBack() {
        onBackPressedDispatcher.onBackPressed()
    }

    override fun addItemToCart() {
        EventBus.getDefault().post(CartEvent("Zanahoria"))
    }
}

@Composable
fun ShowItems(listener: OnClickListener, modifier: Modifier = Modifier) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Item 1", textAlign = TextAlign.Center)
            Spacer(modifier = modifier.width(Dp(30f)))
            Button(onClick = {listener.addItemToCart()}) {
                Text(text = "Add Item to Cart")
            }
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Item 2", textAlign = TextAlign.Center)
            Spacer(modifier = modifier.width(Dp(30f)))
            Button(onClick = {listener.addItemToCart()}) {
                Text(text = "Add Item to Cart")
            }
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Item 3", textAlign = TextAlign.Center)
            Spacer(modifier = modifier.width(Dp(30f)))
            Button(onClick = {listener.addItemToCart()}) {
                Text(text = "Add Item to Cart")
            }
        }
        Spacer(modifier = modifier.width(Dp(30f)))
        Button(onClick = {listener.onBack()}) {
            Text(text = "Regresar")
        }
    }
}

interface OnClickListener {
    fun onBack()
    fun addItemToCart()
}