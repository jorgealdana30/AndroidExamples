package com.jorgealdana.eventbusexample

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.jorgealdana.eventbusexample.classes.CartEvent
import com.jorgealdana.eventbusexample.classes.viewmodel.MainActivityViewModel
import com.jorgealdana.eventbusexample.ui.theme.EventBusExampleTheme
import com.jorgealdana.eventbusexample.ui.views.ItemsActivity
import kotlinx.coroutines.launch
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class MainActivity : ComponentActivity() {

    private val cartEventList = ArrayList<CartEvent>()
    private var count = 0
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.stateCount.collect {
                    count = it
                }
            }
        }

        setContent {
            EventBusExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TotalItems(viewModel, onClick = {
                        startItemsActivity()
                    })
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (!EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().register(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe
    fun onCartItemAdd(cartEvent: CartEvent) {
        cartEventList.add(cartEvent)
        viewModel.setCount(cartEventList.size)
        Toast.makeText(this, "${cartEvent.cartItem} added to cart.", Toast.LENGTH_SHORT).show()
    }

    private fun startItemsActivity() {
        startActivity(Intent(this, ItemsActivity::class.java))
    }
}

@Composable
fun TotalItems(viewModel: MainActivityViewModel, onClick: () -> Unit, modifier: Modifier = Modifier) {
    val count by viewModel.stateCount.collectAsState()
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Cart Item: $count",
            modifier = modifier
        )
        Button(
            modifier = modifier,
            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
            onClick = onClick
        ) {
            Text(text = "Mostrar items")
        }
    }
}