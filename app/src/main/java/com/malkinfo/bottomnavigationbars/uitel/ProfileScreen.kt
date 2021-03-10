package com.malkinfo.bottomnavigationbars.uitel

import android.graphics.Color.green
import android.provider.ContactsContract
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.malkinfo.bottomnavigationbars.ui.theme.Green100
import com.malkinfo.bottomnavigationbars.ui.theme.Purple200

@Composable
fun ProfileScreen(){

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Yellow)

        ,
        verticalArrangement = Arrangement.Center
            ){
        Row (
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
                ){
            Card (
                modifier = Modifier.padding(1.dp),
                elevation = 16.dp,
                shape = CircleShape
                    ){
                Image(modifier = Modifier.padding(25.dp),
                    imageVector = Icons.Default.Person,
                    contentDescription ="Profile",
                    colorFilter = ColorFilter.lighting(Color.Blue,
                        add = Color.Blue)
                )

            }
            Spacer(modifier = Modifier.padding(5.dp))
            Text(text = "Profile Screen",
                style = TextStyle(
                    fontSize = 22.sp,
                    fontStyle = FontStyle.Normal
                ),
                color = Color.Blue
            )


        }

    }
}