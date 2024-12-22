package me.visola.focuslauncher.ui

import android.content.Intent
import android.content.pm.PackageManager
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Application(modifier: Modifier = Modifier) {
    val i = Intent(Intent.ACTION_MAIN)
    i.addCategory(Intent.CATEGORY_LAUNCHER)
    val flags = PackageManager.ResolveInfoFlags.of(PackageManager.MATCH_ALL.toLong())

    val packageManager = LocalContext.current.packageManager
    val appList: List<ApplicationInfo> = packageManager
        .queryIntentActivities(i, flags)
        .map { app ->
            ApplicationInfo(
                app.loadLabel(packageManager).toString(),
                app.activityInfo.packageName,
            )
        }
        .sortedBy { it.name.lowercase() }

    val pagerState = rememberPagerState(pageCount = { 2 })

    HorizontalPager(
        modifier = modifier.fillMaxSize(),
        state = pagerState,
        verticalAlignment = Alignment.Top,
    ) { page ->
        if (page == 0) Home(appList, modifier = modifier)
        else ApplicationList(appList, modifier = modifier)
    }
}