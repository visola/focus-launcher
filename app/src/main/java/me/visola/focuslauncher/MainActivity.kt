package me.visola.focuslauncher

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import me.visola.focuslauncher.ui.ApplicationInfo
import me.visola.focuslauncher.ui.Home
import me.visola.focuslauncher.ui.theme.FocusLauncherTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val i = Intent(Intent.ACTION_MAIN)
        i.addCategory(Intent.CATEGORY_LAUNCHER)
        val flags = PackageManager.ResolveInfoFlags.of(PackageManager.MATCH_ALL.toLong())

        val appList: List<ApplicationInfo> = this.packageManager
            .queryIntentActivities(i, flags)
            .map { app ->
                ApplicationInfo(
                    app.loadLabel(this.packageManager).toString(),
                    app.activityInfo.packageName,
                )
            }
            .sortedBy { it.name.lowercase() }

        setContent {
            FocusLauncherTheme {
                Scaffold { innerPadding ->
                    Home(appList, Modifier.padding(innerPadding))
                }
            }
        }
    }
}
