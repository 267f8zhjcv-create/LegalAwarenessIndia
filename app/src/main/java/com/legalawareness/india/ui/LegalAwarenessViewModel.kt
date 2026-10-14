package com.legalawareness.india.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.legalawareness.india.data.AppLanguage
import com.legalawareness.india.data.LegalContent
import com.legalawareness.india.preferences.UserPreferencesRepository
import java.io.IOException
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class LegalAwarenessUiState(
    val language: AppLanguage,
    val bookmarks: Set<String> = emptySet(),
    val loaded: Boolean = false,
)

class LegalAwarenessViewModel(private val repository: UserPreferencesRepository) : ViewModel() {
    val uiState: StateFlow<LegalAwarenessUiState> = repository.preferences
        .map { LegalAwarenessUiState(it.language, it.bookmarks, loaded = true) }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            LegalAwarenessUiState(repository.defaultLanguage),
        )

    private val _saveFailed = MutableStateFlow(false)
    val saveFailed = _saveFailed.asStateFlow()

    fun setLanguage(language: AppLanguage) = persist { repository.setLanguage(language) }

    fun toggleBookmark(articleId: String) {
        if (uiState.value.loaded && LegalContent.articleById(articleId) != null) {
            persist { repository.toggleBookmark(articleId) }
        }
    }

    fun acknowledgeError() { _saveFailed.value = false }

    private fun persist(action: suspend () -> Unit) {
        viewModelScope.launch {
            try {
                action()
            } catch (cancelled: CancellationException) {
                throw cancelled
            } catch (_: IOException) {
                _saveFailed.value = true
            }
        }
    }
}
