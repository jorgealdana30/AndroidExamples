package com.example.animationsexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Animatable
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateOffset
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.animationsexample.ui.theme.AnimationsExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimationsExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AnimateFloatAsState()
                }
            }
        }
    }
}

@Composable
fun AnimatableExample() {
    var isAnimated by remember { mutableStateOf(false) }
    val color = remember { Animatable(Color.Blue) }

    //It is a Coroutine that is triggered when isAnimated changes its value
    LaunchedEffect(isAnimated) {
        color.animateTo(if (isAnimated) Color.Green else Color.Red, animationSpec = tween(2000))
    }
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
                .background(color.value)
        )
        Button(onClick = { isAnimated = !isAnimated }) {
            Text(text = "Animate color")
        }
    }
}

@Composable
fun CircleImage(animatedSizeDp: Dp) {
    Image(
        painter = painterResource(R.drawable.foto),
        contentDescription = "Circle Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(animatedSizeDp)
            .clip(CircleShape)
            .border(5.dp, Color.Gray, CircleShape)
    )
}

@Composable
fun AnimateDpAsState() {
    val isNeedExpansion = remember { mutableStateOf(false) }
    val animatedSizeDp by animateDpAsState(
        targetValue = if (isNeedExpansion.value) 300.dp else 100.dp,
        label = "", animationSpec = tween(1000)
    )

    Column(modifier = Modifier.padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        CircleImage(animatedSizeDp)
        Button(
            onClick = { isNeedExpansion.value = !isNeedExpansion.value }, modifier = Modifier
                .padding(top = 10.dp)
                .width(300.dp)
        ) {
            Text(text = "Animate image")
        }
    }
}

@Composable
fun AnimateFloatAsState() {
    var isNeedExpansion by remember { mutableStateOf(false) }
    val transition = updateTransition(targetState = isNeedExpansion, label = "transition")
    val offset by transition.animateOffset(transitionSpec = {
        if (this.targetState) {
            tween(1000)
        } else {
            tween(1500)
        }
    }, label = "offset") {
        if (it)
            Offset(200f, 0f)
        else
            Offset(200f, 500f)
    }

    val size by transition.animateDp(transitionSpec = {
        tween(1000)
    }, label = "") {
        if (it) 75.dp else 150.dp
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = "fan",
            modifier = Modifier
                .size(size)
                .alpha(1.0f)
                .offset(offset.x.dp, offset.y.dp)
        )
        Button(
            onClick = { isNeedExpansion = !isNeedExpansion }, modifier = Modifier
                .padding(top = 10.dp)
                .width(300.dp)
        ) {
            Text(text = if(!isNeedExpansion) "Launch Rocket!" else "Land Rocket!")
        }
    }
}

@Composable
fun AnimateColorAsState() {
    var isNeedColorChange by remember { mutableStateOf(false) }
    val startColor = Color.Blue
    val endColor = Color.Green

    val backgroundColor by animateColorAsState(
        targetValue = if (isNeedColorChange) endColor else startColor,
        animationSpec = tween(2000, 100, LinearEasing),
        label = ""
    )

    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
                .background(backgroundColor)
        )
        Button(
            onClick = { isNeedColorChange = !isNeedColorChange },
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Text(text = "Switch Color")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AnimationsExampleTheme {

    }
}