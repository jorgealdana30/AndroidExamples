package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.classes.MenuItem
import com.example.myapplication.classes.MenuItem.*
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.views.AccountView
import com.example.myapplication.views.GalleryView
import com.example.myapplication.views.HomeView
import com.example.myapplication.views.ListView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ScaffoldSample()
                }
            }
        }
    }
}

@Composable
fun NavHostExample(navController: NavHostController) {
    NavHost(navController = navController, startDestination = HomeItem.ruta) {
        composable(HomeItem.ruta) {
            HomeView()
        }
        composable(ListItem.ruta) {
            ListView()
        }
        composable(AccountItem.ruta) {
            AccountView()
        }
        composable(GalleryItem.ruta){
            GalleryView()
        }
    }
}

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarExample() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Back", color = Color.White) },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Outlined.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                }
            )
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .consumeWindowInsets(it)
                .background(MaterialTheme.colorScheme.secondary)
                .fillMaxSize()
        ) {
            Text(
                text = "Content of the page",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val entrant by navController.currentBackStackEntryAsState()
    return entrant?.destination?.route
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun ScaffoldSample() {
    val navController = rememberNavController()
    val navigationItem = listOf(
        HomeItem,
        ListItem,
        GalleryItem,
        AccountItem
    )
    Scaffold(
        topBar = {
            TopAppBar(
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Outlined.Favorite,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Outlined.ShoppingCart,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
                title = { Text(text = "Scaffold Example", color = Color.White) },
                navigationIcon = {
                    IconButton(
                        onClick = {}) {
                        Icon(
                            imageVector = Icons.Outlined.Menu,
                            contentDescription = "Menu",
                            tint = Color.White
                        )
                    }
                })
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(
                containerColor = MaterialTheme.colorScheme.secondary,
                shape = RoundedCornerShape(15.dp),
                onClick = { }) {
                Icon(imageVector = Icons.Outlined.Add, contentDescription = "Fab Icon")
            }
        },
        bottomBar = {
            BottomAppBar {
                NavigationBar {
                    val currentRoute = currentRoute(navController = navController)
                    navigationItem.forEach { item ->
                        NavigationBarItem(
                            alwaysShowLabel = false,
                            label = {
                                Text(text = item.name)
                            }, selected = currentRoute == item.ruta,
                            onClick = {
                                navController.navigate(item.ruta)
                            }, icon = {
                                Icon(
                                    painter = painterResource(id = item.icon),
                                    contentDescription = item.name
                                )
                            })
                    }
                }
            }
        },
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.consumeWindowInsets(innerPadding), contentPadding = innerPadding) {
            item {
                NavHostExample(navController = navController)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    ScaffoldSample()
    //TopAppBarExample()
}