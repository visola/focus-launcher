package me.visola.focuslauncher.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import me.visola.focuslauncher.FocusLauncherViewModel

@Composable
fun Home(
    appList: List<ApplicationInfo>,
    modifier: Modifier = Modifier,
    focusLauncherViewModel: FocusLauncherViewModel = viewModel()
) {
    val favoriteApps = appList.filter { focusLauncherViewModel.favorites.contains(it.packageName) }

    ApplicationList(favoriteApps, modifier = modifier)
}