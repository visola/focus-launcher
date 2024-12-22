package me.visola.focuslauncher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import me.visola.focuslauncher.ui.Application
import me.visola.focuslauncher.ui.theme.FocusLauncherTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FocusLauncherTheme {
                Scaffold { innerPadding ->
                    Application(Modifier.padding(innerPadding))
                }
            }
        }
    }
}
