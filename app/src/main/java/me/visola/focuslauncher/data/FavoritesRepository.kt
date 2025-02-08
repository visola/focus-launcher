package me.visola.focuslauncher.data

import android.content.SharedPreferences

class FavoritesRepository(val preferences: SharedPreferences) {
    private val FAVORITES = "favorites"

    var favorites: MutableSet<String> = preferences.getStringSet(FAVORITES, HashSet()) ?: HashSet()

    fun addToFavorites(packageName: String) {
        favorites.add(packageName)
        with (preferences.edit()) {
            putStringSet(FAVORITES, favorites)
            apply()
        }
    }

    fun removeFromFavorites(packageName: String) {
        favorites.remove(packageName)
        with (preferences.edit()) {
            putStringSet(FAVORITES, favorites)
            apply()
        }
    }

}
