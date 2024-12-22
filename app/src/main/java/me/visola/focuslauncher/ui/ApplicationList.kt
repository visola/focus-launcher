package me.visola.focuslauncher.ui

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext


data class ApplicationInfo(
    val name: String,
    val packageName: String,
)

@Composable
fun ApplicationList(appList: List<ApplicationInfo>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier,
    ) {
        items(appList) { appInfo -> ApplicationItem(appInfo, modifier) }
    }
}


@Composable
fun ApplicationItem(appInfo: ApplicationInfo, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val launchIntent: Intent? = context.packageManager.getLaunchIntentForPackage(appInfo.packageName)
    Text(
        modifier = modifier
            .fillMaxSize()
            .clickable { context.startActivity(launchIntent) },
        text = appInfo.name,
    )
}