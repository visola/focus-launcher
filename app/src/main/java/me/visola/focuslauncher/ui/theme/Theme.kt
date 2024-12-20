package me.visola.focuslauncher.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val FocusLauncherScheme = darkColorScheme(
    primary = Grey20,
    secondary = Grey60,
    tertiary = Grey20,

    background = Grey80,
)

@Composable
fun FocusLauncherTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = FocusLauncherScheme,
        content = content,
        typography = Typography,
    )
}