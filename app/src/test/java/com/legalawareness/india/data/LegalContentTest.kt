package com.legalawareness.india.data

import java.net.URI
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class LegalContentTest {
    @Test
    fun languageCodesResolveWithSafeFallback() {
        assertEquals(AppLanguage.TELUGU, AppLanguage.fromCode("te"))
        assertEquals(AppLanguage.TELUGU, AppLanguage.fromCode("TE"))
        assertEquals(AppLanguage.ENGLISH, AppLanguage.fromCode(null))
        assertEquals(AppLanguage.ENGLISH, AppLanguage.fromCode("unknown"))
        val label = LocalizedText("Rights", "హక్కులు")
        assertEquals("Rights", label.resolve(AppLanguage.ENGLISH))
        assertEquals("హక్కులు", label.resolve(AppLanguage.TELUGU))
    }

    @Test
    fun searchSupportsEnglishTeluguAndArticleBodyText() {
        assertTrue(LegalContent.search("  CYBER fraud  ").any { it.id == "financial-cyber-fraud" })
        assertTrue(LegalContent.search("సైబర్ మోసం").any { it.id == "financial-cyber-fraud" })
        assertTrue(LegalContent.search("1930").any { it.id == "financial-cyber-fraud" })
        assertTrue(LegalContent.search("ప్రజా సమాచార").any { it.id == "right-to-information" })
        assertTrue(LegalContent.search("no-such-topic-123456").isEmpty())
    }

    @Test
    fun categoryNamesAreSearchableInBothLanguages() {
        assertEquals(
            LegalContent.articles.filter { it.categoryId == "workplace" }.map { it.id },
            LegalContent.search("At work", "workplace").map { it.id },
        )
        assertEquals(
            LegalContent.articles.filter { it.categoryId == "consumer" }.map { it.id },
            LegalContent.search("వినియోగదారుల రక్షణ", "consumer").map { it.id },
        )
    }

    @Test
    fun filteringRestrictsResultsAndBlankSearchKeepsCatalogOrder() {
        assertEquals(LegalContent.articles, LegalContent.search(" \n\t "))
        val results = LegalContent.search("", "rights")
        assertEquals(2, results.size)
        assertTrue(results.all { it.categoryId == "rights" })
        assertTrue(LegalContent.search("", "unknown-category").isEmpty())
        assertTrue(LegalContent.search("1930", "family").isEmpty())
    }

    @Test
    fun catalogHasStableUniqueIdsCompleteTranslationsAndSources() {
        assertEquals(6, LegalContent.categories.size)
        assertEquals(12, LegalContent.articles.size)
        assertEquals(6, LegalContent.categories.map { it.id }.toSet().size)
        assertEquals(12, LegalContent.articles.map { it.id }.toSet().size)
        val categoryIds = LegalContent.categories.map { it.id }.toSet()
        LegalContent.categories.forEach {
            assertTranslated(it.name)
            assertTranslated(it.description)
            assertEquals(2, LegalContent.articles.count { article -> article.categoryId == it.id })
        }
        LegalContent.articles.forEach { article ->
            assertTrue(article.categoryId in categoryIds)
            assertTrue(article.readingMinutes > 0)
            assertTranslated(article.title)
            assertTranslated(article.summary)
            assertFalse(article.sections.isEmpty())
            article.sections.forEach {
                assertTranslated(it.heading)
                assertTranslated(it.body)
            }
            assertFalse(article.sources.isEmpty())
            article.sources.forEach {
                assertTrue(it.title.isNotBlank())
                val uri = URI(it.url)
                assertEquals("https", uri.scheme)
                assertNotNull(uri.host)
                assertTrue(uri.host.endsWith(".gov.in") || uri.host.endsWith(".nic.in") ||
                    uri.host.endsWith(".rbi.org.in") || uri.host.endsWith(".npci.org.in"))
            }
            assertEquals(article, LegalContent.articleById(article.id))
        }
        assertNull(LegalContent.articleById("unknown-article"))
        assertTranslated(LegalContent.disclaimer)
    }

    private fun assertTranslated(text: LocalizedText) {
        assertTrue(text.english.isNotBlank())
        assertTrue(text.telugu.isNotBlank())
        assertTrue(text.telugu.any { it in '\u0C00'..'\u0C7F' })
    }
}
