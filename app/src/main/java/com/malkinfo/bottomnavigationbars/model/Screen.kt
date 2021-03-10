package com.malkinfo.bottomnavigationbars.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen (
    val route:String,
    val label:String,
    val icon:ImageVector
        ){
    object Profile:Screen("profile","Profile",Icons.Default.Person)
    object Edit:Screen("edit","Edit",Icons.Default.Edit)
    object Favorite:Screen("favorite","Favorite",Icons.Default.Favorite)
    object Notification:Screen("notification","Notification",Icons.Default.Notifications)
}