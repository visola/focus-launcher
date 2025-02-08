package me.visola.focuslauncher

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import me.visola.focuslauncher.data.FavoritesRepository

class FocusLauncherViewModel(private val favoritesRepository: FavoritesRepository) : ViewModel() {

    val favorites = favoritesRepository.favorites.toMutableStateList()

    fun addToFavorites(packageName: String) {
        favoritesRepository.addToFavorites(packageName)
        favorites.add(packageName)
    }

    fun removeFromFavorites(packageName: String) {
        favoritesRepository.removeFromFavorites(packageName)
        favorites.remove(packageName)
    }

}

class FocusLauncherViewModelFactory(
    private val favoritesRepository: FavoritesRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FocusLauncherViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FocusLauncherViewModel(favoritesRepository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class $modelClass")
    }
}