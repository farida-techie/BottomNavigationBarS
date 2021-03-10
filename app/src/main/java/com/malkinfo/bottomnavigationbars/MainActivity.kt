package com.malkinfo.bottomnavigationbars

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.malkinfo.bottomnavigationbars.model.Screen
import com.malkinfo.bottomnavigationbars.ui.theme.BottomNavigationBarSTheme
import com.malkinfo.bottomnavigationbars.uitel.EditScreen
import com.malkinfo.bottomnavigationbars.uitel.FavoriteScreen
import com.malkinfo.bottomnavigationbars.uitel.NotificationScreen
import com.malkinfo.bottomnavigationbars.uitel.ProfileScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomNavigationBarSTheme {
               val navController = rememberNavController()
                val titless = remember{ mutableStateOf("Profile")}
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                  /**set TopApp And Bottom Bar*/
                    Scaffold (
                        topBar = {
                            TopAppBar(
                                title = { Text(text = titless.value)},
                                actions = {
                                    IconButton(onClick = {
                                        Toast.makeText(this@MainActivity,
                                        "This is Search",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }) {
                                        Icon(imageVector = Icons.Default.Search,
                                            contentDescription = "Search")
                                    }
                                }
                            )
                        },
                        bottomBar = {
                            val items = listOf<Screen>(
                                Screen.Profile,
                                Screen.Edit,
                                Screen.Favorite,
                                Screen.Notification,
                            )
                            /**set design*/
                            BottomNavigation (
                                backgroundColor = Color.Transparent,
                                elevation = 15.dp,
                                modifier = Modifier
                                    .padding(
                                        start = 22.dp,
                                        end = 22.dp,
                                        bottom = 15.dp,
                                        top = 10.dp
                                    )
                                    ){
                                val navBackStackEntry by navController
                                    .currentBackStackEntryAsState()
                                val currentRoute = navBackStackEntry
                                    ?.arguments?.getString(KEY_ROUTE)
                                items.forEach {
                                    BottomNavigationItem(
                                        modifier = Modifier
                                            .background(Color.White,shape = RectangleShape),
                                        unselectedContentColor = Color.Blue,
                                        selectedContentColor = Color.Red,
                                        icon = { Icon(
                                        imageVector = it.icon,
                                        contentDescription = "Profile"
                                    )},
                                        selected = currentRoute == it.route ,
                                        onClick = {
                                            navController.popBackStack(
                                                navController.graph.startDestination,
                                                false
                                            )
                                            if (currentRoute != it.route){
                                                navController.navigate(it.route)
                                            }
                                        }
                                    )
                                }
                            }
                        }
                            ){
                        SreenController(navController = navController,
                            topTitleBar = titless)
                    }

                }
            }

        }

    }
}

@Composable
fun SreenController(
    navController: NavHostController,
    topTitleBar:MutableState<String>
    ){
    NavHost(navController =navController,
        startDestination = "profile"
         )
    {
       composable("profile"){
           ProfileScreen()
           topTitleBar.value = "profile"
       }
        composable("edit"){
            EditScreen()
            topTitleBar.value = "Edit"
        }
        composable("favorite"){
           FavoriteScreen()
            topTitleBar.value = "Favorite"
        }
        composable("notification"){
            NotificationScreen()
            topTitleBar.value = "Notification"
        }
    }

}
/** ok now run it*/


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BottomNavigationBarSTheme {
        Greeting("Android")
    }
}