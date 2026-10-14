package com.legalawareness.india

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.legalawareness.india.preferences.UserPreferencesRepository
import com.legalawareness.india.ui.LegalAwarenessApp
import com.legalawareness.india.ui.LegalAwarenessViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val model: LegalAwarenessViewModel = viewModel(factory = viewModelFactory {
                initializer { LegalAwarenessViewModel(UserPreferencesRepository(applicationContext)) }
            })
            LegalAwarenessApp(model)
        }
    }
}
