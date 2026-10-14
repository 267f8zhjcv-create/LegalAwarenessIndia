package com.legalawareness.india.preferences

import android.content.Context
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.legalawareness.india.data.AppLanguage
import java.io.IOException
import java.util.Locale
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

private val Context.userPreferences by preferencesDataStore(
    name = "legal_awareness_preferences",
    corruptionHandler = ReplaceFileCorruptionHandler { emptyPreferences() },
)

data class UserPreferences(
    val language: AppLanguage,
    val bookmarks: Set<String>,
)

/** The first launch follows the device language; an explicit choice persists locally. */
class UserPreferencesRepository(context: Context) {
    private val dataStore = context.applicationContext.userPreferences
    val defaultLanguage = if (Locale.getDefault().language == "te") AppLanguage.TELUGU else AppLanguage.ENGLISH

    val preferences: Flow<UserPreferences> = dataStore.data
        .catch { failure ->
            if (failure is IOException) emit(emptyPreferences()) else throw failure
        }
        .map { values ->
            UserPreferences(
                language = values[LANGUAGE]?.let { AppLanguage.fromCode(it) } ?: defaultLanguage,
                bookmarks = values[BOOKMARKS].orEmpty(),
            )
        }

    suspend fun setLanguage(language: AppLanguage) {
        dataStore.edit { it[LANGUAGE] = language.code }
    }

    suspend fun toggleBookmark(articleId: String) {
        dataStore.edit { values ->
            val bookmarks = values[BOOKMARKS].orEmpty().toMutableSet()
            if (!bookmarks.add(articleId)) bookmarks.remove(articleId)
            values[BOOKMARKS] = bookmarks
        }
    }

    private companion object {
        val LANGUAGE = stringPreferencesKey("language")
        val BOOKMARKS = stringSetPreferencesKey("bookmarks")
    }
}
