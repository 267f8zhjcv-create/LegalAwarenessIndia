package com.legalawareness.india.data

enum class AppLanguage(val code: String) {
    ENGLISH("en"),
    TELUGU("te");

    companion object {
        fun fromCode(code: String?): AppLanguage =
            entries.firstOrNull { it.code.equals(code, ignoreCase = true) } ?: ENGLISH
    }
}

data class LocalizedText(val english: String, val telugu: String) {
    fun resolve(language: AppLanguage): String = when (language) {
        AppLanguage.ENGLISH -> english
        AppLanguage.TELUGU -> telugu
    }
}

data class LegalCategory(
    val id: String,
    val name: LocalizedText,
    val description: LocalizedText,
)

data class ArticleSection(val heading: LocalizedText, val body: LocalizedText)

data class LegalSource(val title: String, val url: String)

data class LegalArticle(
    val id: String,
    val categoryId: String,
    val title: LocalizedText,
    val summary: LocalizedText,
    val sections: List<ArticleSection>,
    val sources: List<LegalSource>,
    val readingMinutes: Int,
)
