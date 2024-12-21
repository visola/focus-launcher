package me.visola.focuslauncher

import androidx.lifecycle.ViewModel

class FocusLauncherViewModel : ViewModel() {
    private val _favorites = arrayListOf("com.android.chrome", "com.google.android.gm")

    val favorites: List<String>
        get() = _favorites
}
