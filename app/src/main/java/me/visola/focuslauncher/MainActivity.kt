package me.visola.focuslauncher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import me.visola.focuslauncher.data.FavoritesRepository
import me.visola.focuslauncher.ui.Application
import me.visola.focuslauncher.ui.theme.FocusLauncherTheme

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: FocusLauncherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        viewModel = ViewModelProvider(
            this,
            FocusLauncherViewModelFactory(FavoritesRepository(getPreferences(MODE_PRIVATE)))
        )[FocusLauncherViewModel::class.java]

        setContent {
            FocusLauncherTheme {
                Scaffold { innerPadding ->
                    Application(Modifier.padding(innerPadding))
                }
            }
        }
    }
}
