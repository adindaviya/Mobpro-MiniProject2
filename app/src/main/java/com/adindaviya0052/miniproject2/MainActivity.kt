package com.adindaviya0052.miniproject2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.adindaviya0052.miniproject2.ui.screen.MainScreen
import com.adindaviya0052.miniproject2.ui.theme.MiniProject2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiniProject2Theme {
                MainScreen()
            }
        }
    }
}
