package com.example.myapplication.classes

import com.example.myapplication.R

sealed class MenuItem(val icon: Int, val name: String, val ruta: String) {
    object HomeItem : MenuItem(R.drawable.home, "Home", "home")
    object ListItem : MenuItem(R.drawable.list, "List", "list")
    object AccountItem : MenuItem(R.drawable.account, "Account", "account")
    object GalleryItem : MenuItem(R.drawable.gallery, "Gallery", "gallery")
}
