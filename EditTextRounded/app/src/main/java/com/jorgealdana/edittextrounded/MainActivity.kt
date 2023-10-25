package com.jorgealdana.edittextrounded

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp
import com.jorgealdana.edittextrounded.ui.theme.EditTextRoundedTheme
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EditTextRoundedTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = "TextField Exercises", color = Color.DarkGray, fontWeight = FontWeight.Bold, fontSize = 30.sp)
                        Spacer(modifier = Modifier.height(Dp(30f)))
                        //---------------------------------------------------
                        BasicTextField()
                        TextFieldWithLabelAndPlaceHolder()
                        TextFieldWithKeyboardOptions()
                        OutlinedTextField()
                        TextFieldWithIcons()
                    }
                }
            }
        }
    }
}

@Composable
fun TextFieldWithLabelAndPlaceHolder() {
    var text by remember {
        mutableStateOf(TextFieldValue(""))
    }
    Column {
        Text(text = "TextField with Label and PlaceHolder")
        Spacer(modifier = Modifier.height(Dp(10f)))
        TextField(
            value = text,
            placeholder = { Text(text = "Ingresa Texto") },
            label = { Text("This is a Label") },
            onValueChange = { text = it })
    }
    Spacer(modifier = Modifier.height(Dp(30f)))
}

@Composable
fun BasicTextField() {
    var text by remember {
        mutableStateOf(TextFieldValue(""))
    }
    Column {
        Text(text = "Basic Text Field")
        TextField(value = text, onValueChange = { newText ->
            text = newText
        })
    }
    Spacer(modifier = Modifier.height(Dp(30f)))
}

@Composable
fun TextFieldWithKeyboardOptions() {
    var text by remember {
        mutableStateOf(TextFieldValue(""))
    }
    Column {
        Text(text = "TextField with Keyboard options")
        Spacer(modifier = Modifier.height(Dp(10f)))
        TextField(
            value = text,
            onValueChange = { text = it },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences,
                autoCorrect = true,
                keyboardType = KeyboardType.Ascii,
                imeAction = ImeAction.Send
            )
        )
    }
    Spacer(modifier = Modifier.height(Dp(30f)))
}

@Composable
fun OutlinedTextField() {
    var text by remember {
        mutableStateOf(TextFieldValue(""))
    }
    Column {
        Text(text = "TextField with outlined attribute")
        Spacer(modifier = Modifier.height(Dp(10f)))
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text(text = "Enter your name") })
    }
    Spacer(modifier = Modifier.height(Dp(30f)))
}

@Composable
fun TextFieldWithIcons() {
    var text by remember {
        mutableStateOf(TextFieldValue(""))
    }
    Column {
        Text(text = "TextField with icons")
        Spacer(modifier = Modifier.height(Dp(10f)))
        OutlinedTextField(
            value = text, onValueChange = { text = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "emailIcon"
                )
            },
            //trailingIcon = { Icon(imageVector = Icons.Default.Email , contentDescription = "emailIcon")},
            label = { Text(text = "Email Address") },
            placeholder = { Text(text = "Enter your e-mail") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
    }
    Spacer(modifier = Modifier.height(Dp(30f)))
}
