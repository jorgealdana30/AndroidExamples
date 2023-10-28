package com.jorgealdana.buttonsexample

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jorgealdana.buttonsexample.ui.theme.ButtonsExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ButtonsExampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = Color.White
                ) {
                    Column {
                        SimpleButton()
                        SpaceHeight()
                        ButtonWithCustomColor()
                        SpaceHeight()
                        ButtonWithMultipleText()
                        SpaceHeight()
                        ButtonWithIcon()
                        SpaceHeight()
                        ButtonRectangle()
                        SpaceHeight()
                        ButtonRounded()
                        SpaceHeight()
                        ButtonCut()
                        SpaceHeight()
                        ButtonWithBorder()
                        SpaceHeight()
                        ButtonWithElevation()
                    }
                }
            }
        }
    }
}

@Composable
fun SimpleButton() {
    Button(onClick = {

    }) {
        Text(text = "Simple Button")
    }
}

@Composable
fun ButtonWithCustomColor() {
    Button(
        onClick = { }, colors = ButtonDefaults.buttonColors(
            contentColor = Color.Green, containerColor = MaterialTheme.colorScheme.error
        )
    ) {
        Text(text = "Button With custom Color")
    }
}

@Composable
fun ButtonWithMultipleText() {
    Button(onClick = { }) {
        Text(text = "Click ", color = Color.Blue)
        Text(text = "Here", color = Color.Yellow)
    }
}

@Composable
fun ButtonWithIcon() {
    Button(onClick = { }) {
        Image(painter = painterResource(id = R.drawable.ic_cart), contentDescription = "Icon cart")
        Text(text = "Add item to cart")
    }
}

@Composable
fun ButtonRectangle() {
    Button(onClick = { /*TODO*/ }, shape = RectangleShape) {
        Text(text = "Rectangle button")
    }
}

@Composable
fun ButtonRounded() {
    Button(onClick = { /*TODO*/ }, shape = CircleShape) {
        Text(text = "Button Rounded")
    }
}

@Composable
fun ButtonCut() {
    Button(onClick = { /*TODO*/ }, shape = CutCornerShape(20)) {
        Text(text = "Button Cut Corned")
    }
}

@Composable
fun ButtonWithBorder() {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red),
        border = BorderStroke(1.dp, Color.Red)
    ) {
        Text(text = "Button with Border")
    }
}

@Composable
fun ButtonWithElevation() {
    Button(
        onClick = { /*TODO*/ }, elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 10.dp, pressedElevation = 15.dp, disabledElevation = 0.dp
        )
    ) {
        Text(text = "Button With Elevation")
    }
}

@Composable
fun SpaceHeight() {
    Spacer(modifier = Modifier.height(20.dp))
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    ButtonsExampleTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = Color.White
        ) {
            Column {
                SimpleButton()
                SpaceHeight()
                ButtonWithCustomColor()
                SpaceHeight()
                ButtonWithMultipleText()
                SpaceHeight()
                ButtonWithIcon()
                SpaceHeight()
                ButtonRectangle()
                SpaceHeight()
                ButtonRounded()
                SpaceHeight()
                ButtonCut()
                SpaceHeight()
                ButtonWithBorder()
                SpaceHeight()
                ButtonWithElevation()
            }
        }
    }
}