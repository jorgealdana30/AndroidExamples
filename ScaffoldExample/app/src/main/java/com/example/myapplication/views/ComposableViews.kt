package com.example.myapplication.views

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeView() {
    Text(text = "Home", style = MaterialTheme.typography.headlineMedium)
}

@Composable
fun ListView() {
    Text(text = "Lista", style = MaterialTheme.typography.headlineMedium)
}

@Composable
fun AccountView() {
    Text(text = "Account", style = MaterialTheme.typography.headlineMedium)
}

@Composable
fun GalleryView(){
    Text(text = "Gallery", style = MaterialTheme.typography.headlineMedium)
}