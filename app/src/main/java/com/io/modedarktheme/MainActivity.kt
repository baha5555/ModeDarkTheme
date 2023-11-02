package com.io.modedarktheme

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                Greeting("Android")
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.primary), contentAlignment = Alignment.Center) {
        Text(
            text = "Hello $name!",
            color = MaterialTheme.colors.onPrimary, fontSize = 34.sp
        )
    }
}


@SuppressLint("ConflictingOnColor")
private val DarkColor = darkColors(
    primary = Black,
    primaryVariant = Black,
    secondary = Black,
    onPrimary = Color.Green,
    onSecondary = Black
)
@SuppressLint("ConflictingOnColor")
private val LightColor = lightColors(
    primary = Color.White,
    primaryVariant = Color.White,
    secondary = Color.White,
    onPrimary = Yellow,
    onSecondary = Black
)

@Composable
fun MyTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColor
    } else {
        LightColor
    }
    MaterialTheme(
        colors = colors,
        typography = Typography(),
        shapes = Shapes(),
        content = content
    )
}