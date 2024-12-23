package me.visola.focuslauncher.ui

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import me.visola.focuslauncher.FocusLauncherViewModel


data class ApplicationInfo(
    val name: String,
    val packageName: String,
)

@Composable
fun ApplicationList(
    appList: List<ApplicationInfo>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        contentPadding = PaddingValues(12.dp),
        modifier = modifier,
    ) {
        items(appList) { appInfo -> ApplicationItem(appInfo, modifier) }
    }
}


@Composable
@OptIn(ExperimentalFoundationApi::class)
fun ApplicationItem(
    appInfo: ApplicationInfo,
    modifier: Modifier = Modifier,
    focusLauncherViewModel: FocusLauncherViewModel = viewModel()
) {
    val context = LocalContext.current
    val launchIntent: Intent? = context.packageManager.getLaunchIntentForPackage(appInfo.packageName)
    Text(
        modifier = modifier
            .fillMaxSize()
            .combinedClickable(
                onClick = { context.startActivity(launchIntent) },
                onLongClick = {
                    if (focusLauncherViewModel.favorites.contains(appInfo.packageName)) {
                        focusLauncherViewModel.removeToFavorites(appInfo.packageName)
                        Toast.makeText(
                            context,
                            "${appInfo.name} removed from Bookmarks",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        focusLauncherViewModel.addToFavorites(appInfo.packageName)
                        Toast.makeText(
                            context,
                            "${appInfo.name} added to Bookmarks",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                },
            ),
        style = MaterialTheme.typography.titleLarge,
        text = appInfo.name,
    )
}