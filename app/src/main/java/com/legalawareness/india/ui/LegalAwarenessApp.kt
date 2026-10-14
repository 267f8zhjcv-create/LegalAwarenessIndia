@file:OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)

package com.legalawareness.india.ui

import android.content.res.Configuration
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.automirrored.outlined.ArrowForward
import androidx.compose.material.icons.automirrored.outlined.MenuBook
import androidx.compose.material.icons.outlined.AccountBalance
import androidx.compose.material.icons.outlined.Balance
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.FamilyRestroom
import androidx.compose.material.icons.outlined.Gavel
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Language
import androidx.compose.material.icons.outlined.OpenInNew
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Shield
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material.icons.outlined.WifiOff
import androidx.compose.material.icons.outlined.WorkOutline
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilterChip
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.legalawareness.india.R
import com.legalawareness.india.BuildConfig
import com.legalawareness.india.data.AppLanguage
import com.legalawareness.india.data.LegalArticle
import com.legalawareness.india.data.LegalContent
import com.legalawareness.india.ui.theme.LegalAwarenessTheme
import java.util.Locale
import kotlinx.coroutines.launch

private enum class Destination(val label: Int, val icon: ImageVector) {
    HOME(R.string.nav_home, Icons.Outlined.Home),
    TOPICS(R.string.nav_topics, Icons.AutoMirrored.Outlined.MenuBook),
    BOOKMARKS(R.string.nav_bookmarks, Icons.Outlined.BookmarkBorder),
}

@Composable
fun LegalAwarenessApp(model: LegalAwarenessViewModel) {
    val state by model.uiState.collectAsStateWithLifecycle()
    val saveFailed by model.saveFailed.collectAsStateWithLifecycle()
    LocalizedContent(state.language) {
        LegalAwarenessTheme {
            AppShell(state, saveFailed, model::setLanguage, model::toggleBookmark, model::acknowledgeError)
        }
    }
}

/** Localizes Android resources as well as articles, without restarting the activity. */
@Composable
private fun LocalizedContent(language: AppLanguage, content: @Composable () -> Unit) {
    val baseContext = LocalContext.current
    val baseConfiguration = LocalConfiguration.current
    val configuration = remember(baseConfiguration, language) {
        Configuration(baseConfiguration).apply { setLocale(Locale.forLanguageTag(language.code)) }
    }
    val localizedContext = remember(baseContext, configuration) { baseContext.createConfigurationContext(configuration) }
    CompositionLocalProvider(LocalContext provides localizedContext, LocalConfiguration provides configuration, content = content)
}

@Composable
private fun AppShell(
    state: LegalAwarenessUiState,
    saveFailed: Boolean,
    onLanguage: (AppLanguage) -> Unit,
    onBookmark: (String) -> Unit,
    onErrorShown: () -> Unit,
) {
    var destinationName by rememberSaveable { mutableStateOf(Destination.HOME.name) }
    val destination = Destination.valueOf(destinationName)
    var articleId by rememberSaveable { mutableStateOf<String?>(null) }
    var query by rememberSaveable { mutableStateOf("") }
    var categoryId by rememberSaveable { mutableStateOf<String?>(null) }
    var languageDialog by rememberSaveable { mutableStateOf(false) }
    var aboutDialog by rememberSaveable { mutableStateOf(false) }
    val snackbarHost = remember { SnackbarHostState() }
    val homeGridState = rememberLazyGridState()
    val topicsGridState = rememberLazyGridState()
    val bookmarksGridState = rememberLazyGridState()
    val coroutineScope = rememberCoroutineScope()
    val largeText = LocalConfiguration.current.fontScale > 1.3f
    val errorMessage = stringResource(R.string.save_failed)
    LaunchedEffect(saveFailed) {
        if (saveFailed) {
            snackbarHost.showSnackbar(errorMessage)
            onErrorShown()
        }
    }
    BackHandler(enabled = articleId != null || destination != Destination.HOME) {
        if (articleId != null) articleId = null else destinationName = Destination.HOME.name
    }
    val openTopics: (String?) -> Unit = {
        categoryId = it
        query = ""
        articleId = null
        destinationName = Destination.TOPICS.name
        coroutineScope.launch { topicsGridState.scrollToItem(0) }
    }
    BoxWithConstraints(Modifier.fillMaxSize()) {
        val tablet = maxWidth >= 840.dp
        Row(Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
            if (tablet) {
                NavigationRail(
                    containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
                    modifier = Modifier.fillMaxHeight(),
                    header = {
                        Box(Modifier.padding(top = 24.dp, bottom = 30.dp)) { BrandMark() }
                    },
                ) {
                    Destination.entries.forEach { item ->
                        NavigationRailItem(
                            selected = item == destination,
                            onClick = { destinationName = item.name; articleId = null },
                            icon = { Icon(item.icon, null) },
                            label = { Text(stringResource(item.label)) },
                            modifier = Modifier.padding(vertical = 8.dp),
                        )
                    }
                }
            }
            Scaffold(
                modifier = Modifier.weight(1f),
                containerColor = MaterialTheme.colorScheme.background,
                topBar = {
                    TopAppBar(
                        title = {
                            if (articleId != null) {
                                Text(stringResource(R.string.article_body_label), style = MaterialTheme.typography.titleLarge, maxLines = 1, overflow = TextOverflow.Ellipsis)
                            } else {
                                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                    if (!tablet && !largeText) BrandMark(36)
                                    Column {
                                        Text(stringResource(R.string.app_name), style = MaterialTheme.typography.titleMedium, maxLines = 1, overflow = TextOverflow.Ellipsis)
                                        if (!largeText) Text(stringResource(R.string.app_tagline), style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant, maxLines = 1, overflow = TextOverflow.Ellipsis)
                                    }
                                }
                            }
                        },
                        navigationIcon = {
                            if (articleId != null) IconButton(onClick = { articleId = null }) {
                                Icon(Icons.AutoMirrored.Outlined.ArrowBack, stringResource(R.string.back))
                            }
                        },
                        actions = {
                            TextButton(onClick = { languageDialog = true }) {
                                Icon(Icons.Outlined.Language, stringResource(R.string.choose_language), Modifier.size(19.dp))
                                Spacer(Modifier.width(5.dp))
                                Text(if (state.language == AppLanguage.TELUGU) "తెలుగు" else "EN", style = MaterialTheme.typography.labelLarge)
                            }
                            IconButton(onClick = { aboutDialog = true }) { Icon(Icons.Outlined.Info, stringResource(R.string.about_title)) }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background),
                        expandedHeight = 80.dp,
                    )
                },
                bottomBar = {
                    if (!tablet && articleId == null) NavigationBar(containerColor = MaterialTheme.colorScheme.surfaceContainerLow) {
                        Destination.entries.forEach { item ->
                            NavigationBarItem(
                                selected = item == destination,
                                onClick = { destinationName = item.name; articleId = null },
                                icon = { Icon(item.icon, null) },
                                label = { Text(stringResource(item.label), maxLines = 1) },
                            )
                        }
                    }
                },
                snackbarHost = { SnackbarHost(snackbarHost) },
            ) { padding ->
                Box(Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.TopCenter) {
                    val contentModifier = Modifier.widthIn(max = 1200.dp).fillMaxSize()
                    val selectedArticle = articleId?.let(LegalContent::articleById)
                    if (articleId != null) {
                        if (selectedArticle != null) ArticleScreen(selectedArticle, state, onBookmark, Modifier.widthIn(max = 860.dp).fillMaxSize())
                        else EmptyState(Icons.Outlined.Info, stringResource(R.string.article_not_found), stringResource(R.string.no_results_body), modifier = contentModifier)
                    } else when (destination) {
                        Destination.HOME -> HomeScreen(state, onBookmark, { articleId = it }, openTopics, homeGridState, contentModifier)
                        Destination.TOPICS -> TopicsScreen(state, query, { query = it }, categoryId, { categoryId = it }, onBookmark, { articleId = it }, topicsGridState, contentModifier)
                        Destination.BOOKMARKS -> BookmarksScreen(state, onBookmark, { articleId = it }, { openTopics(null) }, bookmarksGridState, contentModifier)
                    }
                }
            }
        }
    }
    if (languageDialog) LanguageDialog(state.language, onSelect = { onLanguage(it); languageDialog = false }, onDismiss = { languageDialog = false })
    if (aboutDialog) AboutDialog(onDismiss = { aboutDialog = false })
}

@Composable
private fun BrandMark(size: Int = 42) {
    Box(Modifier.size(size.dp).clip(RoundedCornerShape(13.dp)).background(MaterialTheme.colorScheme.primary), contentAlignment = Alignment.Center) {
        Icon(Icons.Outlined.Balance, null, Modifier.size((size * 0.6).dp), tint = MaterialTheme.colorScheme.onPrimary)
    }
}

@Composable
private fun HomeScreen(
    state: LegalAwarenessUiState,
    onBookmark: (String) -> Unit,
    onArticle: (String) -> Unit,
    onTopics: (String?) -> Unit,
    gridState: LazyGridState,
    modifier: Modifier = Modifier,
) {
    BoxWithConstraints(modifier) {
        val wide = maxWidth >= 720.dp
        LazyVerticalGrid(
            columns = GridCells.Fixed(if (wide) 2 else 1),
            state = gridState,
            contentPadding = PaddingValues(horizontal = if (wide) 28.dp else 20.dp, vertical = 14.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxSize(),
        ) {
            item(span = { GridItemSpan(maxLineSpan) }) {
                Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Text(stringResource(R.string.greeting), style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.weight(1f))
                        Spacer(Modifier.width(8.dp))
                        OfflineBadge()
                    }
                    Hero(onClick = { onTopics(null) })
                    SearchShortcut(onClick = { onTopics(null) })
                    SectionTitle(stringResource(R.string.explore_categories))
                    CategoryCards(state.language, if (LocalConfiguration.current.fontScale > 1.5f) (if (wide) 2 else 1) else (if (wide) 3 else 2), onTopics)
                    SectionTitle(stringResource(R.string.featured_articles), action = stringResource(R.string.see_all), onAction = { onTopics(null) })
                }
            }
            items(LegalContent.articles.take(4), key = { "home-${it.id}" }) { article ->
                ArticleCard(article, state, onBookmark, { onArticle(article.id) })
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    HelpCard()
                    Text(stringResource(R.string.educational_notice), style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp))
                }
            }
        }
    }
}

@Composable
private fun OfflineBadge() {
    Surface(color = MaterialTheme.colorScheme.surfaceContainer, shape = CircleShape) {
        Row(Modifier.padding(horizontal = 10.dp, vertical = 6.dp), horizontalArrangement = Arrangement.spacedBy(5.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Outlined.WifiOff, null, Modifier.size(13.dp), tint = MaterialTheme.colorScheme.primary)
            Text(stringResource(R.string.offline_badge), style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.primary)
        }
    }
}

@Composable
private fun Hero(onClick: () -> Unit) {
    Surface(shape = RoundedCornerShape(28.dp), color = MaterialTheme.colorScheme.primaryContainer) {
        BoxWithConstraints(Modifier.fillMaxWidth()) {
            val wide = maxWidth >= 600.dp
            Row(Modifier.padding(if (wide) 32.dp else 24.dp), verticalAlignment = Alignment.CenterVertically) {
                Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(14.dp)) {
                    Text(stringResource(R.string.knowledge_label), style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.primary)
                    Text(stringResource(R.string.hero_title), style = if (wide) MaterialTheme.typography.displaySmall else MaterialTheme.typography.headlineLarge, color = MaterialTheme.colorScheme.onPrimaryContainer, modifier = Modifier.semantics { heading() })
                    Text(stringResource(R.string.hero_description), style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onPrimaryContainer)
                    Button(onClick = onClick, contentPadding = PaddingValues(horizontal = 20.dp, vertical = 12.dp), shape = RoundedCornerShape(12.dp)) {
                        Text(stringResource(R.string.browse_topics))
                        Spacer(Modifier.width(8.dp))
                        Icon(Icons.AutoMirrored.Outlined.ArrowForward, null, Modifier.size(18.dp))
                    }
                }
                if (wide) {
                    Spacer(Modifier.width(32.dp))
                    Box(Modifier.size(174.dp).clip(CircleShape).background(MaterialTheme.colorScheme.surface.copy(alpha = 0.55f)), contentAlignment = Alignment.Center) {
                        Box(Modifier.size(132.dp).clip(CircleShape).background(MaterialTheme.colorScheme.secondaryContainer), contentAlignment = Alignment.Center) {
                            Icon(Icons.Outlined.Balance, null, Modifier.size(82.dp), tint = MaterialTheme.colorScheme.primary)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SearchShortcut(onClick: () -> Unit) {
    Surface(onClick = onClick, shape = RoundedCornerShape(16.dp), border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant), color = MaterialTheme.colorScheme.surfaceContainerLowest) {
        Row(Modifier.fillMaxWidth().padding(18.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Icon(Icons.Outlined.Search, null, tint = MaterialTheme.colorScheme.primary)
            Text(stringResource(R.string.search_hint), style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.weight(1f))
            Icon(Icons.AutoMirrored.Outlined.ArrowForward, null, Modifier.size(18.dp), tint = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}

@Composable
private fun SectionTitle(title: String, action: String? = null, onAction: () -> Unit = {}) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        Text(title, style = MaterialTheme.typography.titleLarge, modifier = Modifier.weight(1f).semantics { heading() })
        if (action != null) TextButton(onClick = onAction) { Text(action) }
    }
}

@Composable
private fun CategoryCards(language: AppLanguage, columns: Int, onClick: (String?) -> Unit) {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        LegalContent.categories.chunked(columns).forEach { categories ->
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                categories.forEachIndexed { index, category ->
                    val background = when (index % 3) {
                        0 -> MaterialTheme.colorScheme.surfaceContainerLow
                        1 -> MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.65f)
                        else -> MaterialTheme.colorScheme.tertiaryContainer.copy(alpha = 0.65f)
                    }
                    Surface(onClick = { onClick(category.id) }, shape = RoundedCornerShape(16.dp), color = background, modifier = Modifier.weight(1f)) {
                        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                            Icon(categoryIcon(category.id), null, Modifier.size(24.dp), tint = MaterialTheme.colorScheme.primary)
                            Text(category.name.resolve(language), style = MaterialTheme.typography.titleMedium)
                            val count = LegalContent.articles.count { it.categoryId == category.id }
                            Text(pluralStringResource(R.plurals.articles_count, count, count), style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                    }
                }
                repeat(columns - categories.size) { Spacer(Modifier.weight(1f)) }
            }
        }
    }
}

private fun categoryIcon(id: String): ImageVector = when (id) {
    "rights" -> Icons.Outlined.Balance
    "consumer" -> Icons.Outlined.ShoppingBag
    "digital", "cyber", "safety" -> Icons.Outlined.Shield
    "family" -> Icons.Outlined.FamilyRestroom
    "work", "workplace" -> Icons.Outlined.WorkOutline
    "services", "public_services" -> Icons.Outlined.AccountBalance
    else -> Icons.Outlined.Gavel
}

@Composable
private fun ArticleCard(article: LegalArticle, state: LegalAwarenessUiState, onBookmark: (String) -> Unit, onClick: () -> Unit) {
    val category = LegalContent.categories.first { it.id == article.categoryId }
    val saved = article.id in state.bookmarks
    Card(
        onClick = onClick,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainerLowest),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        shape = RoundedCornerShape(20.dp),
    ) {
        Column(Modifier.fillMaxWidth().padding(start = 20.dp, end = 14.dp, top = 12.dp, bottom = 20.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text(category.name.resolve(state.language), style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.primary, modifier = Modifier.weight(1f))
                BookmarkButton(saved, state.loaded) { onBookmark(article.id) }
            }
            Text(article.title.resolve(state.language), style = MaterialTheme.typography.titleLarge, modifier = Modifier.padding(end = 6.dp))
            Text(article.summary.resolve(state.language), style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant, maxLines = 3, overflow = TextOverflow.Ellipsis, modifier = Modifier.padding(end = 6.dp))
            Spacer(Modifier.height(4.dp))
            Row(Modifier.fillMaxWidth().padding(end = 6.dp), verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Outlined.Schedule, null, Modifier.size(15.dp), tint = MaterialTheme.colorScheme.onSurfaceVariant)
                Spacer(Modifier.width(5.dp))
                Text(stringResource(R.string.read_minutes, article.readingMinutes), style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                Spacer(Modifier.weight(1f))
                Icon(Icons.AutoMirrored.Outlined.ArrowForward, null, Modifier.size(19.dp), tint = MaterialTheme.colorScheme.primary)
            }
        }
    }
}

@Composable
private fun BookmarkButton(saved: Boolean, enabled: Boolean, onClick: () -> Unit) {
    IconButton(onClick = onClick, enabled = enabled) {
        Icon(if (saved) Icons.Outlined.Bookmark else Icons.Outlined.BookmarkBorder, stringResource(if (saved) R.string.remove_bookmark else R.string.bookmark_article), tint = MaterialTheme.colorScheme.primary)
    }
}

@Composable
private fun TopicsScreen(
    state: LegalAwarenessUiState,
    query: String,
    onQuery: (String) -> Unit,
    categoryId: String?,
    onCategory: (String?) -> Unit,
    onBookmark: (String) -> Unit,
    onArticle: (String) -> Unit,
    gridState: LazyGridState,
    modifier: Modifier = Modifier,
) {
    val articles = remember(query, categoryId) { LegalContent.search(query, categoryId) }
    val focusManager = LocalFocusManager.current
    ArticleGrid(modifier, articles, state, onBookmark, onArticle, gridState, header = {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            ScreenHeading(stringResource(R.string.topics_title), stringResource(R.string.topics_description))
            OutlinedTextField(
                value = query,
                onValueChange = onQuery,
                modifier = Modifier.fillMaxWidth(),
                label = { Text(stringResource(R.string.search_topics)) },
                placeholder = { Text(stringResource(R.string.search_hint)) },
                leadingIcon = { Icon(Icons.Outlined.Search, null) },
                trailingIcon = {
                    if (query.isNotEmpty()) IconButton(onClick = { onQuery("") }) { Icon(Icons.Outlined.Clear, stringResource(R.string.search_clear)) }
                },
                singleLine = true,
                shape = RoundedCornerShape(16.dp),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(onSearch = { focusManager.clearFocus() }),
            )
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                item {
                    FilterChip(selected = categoryId == null, onClick = { onCategory(null) }, label = { Text(stringResource(R.string.all_categories)) }, leadingIcon = if (categoryId == null) ({ Icon(Icons.Outlined.Check, null, Modifier.size(16.dp)) }) else null)
                }
                items(LegalContent.categories, key = { it.id }) { category ->
                    FilterChip(selected = categoryId == category.id, onClick = { onCategory(category.id) }, label = { Text(category.name.resolve(state.language)) }, leadingIcon = { Icon(categoryIcon(category.id), null, Modifier.size(16.dp)) })
                }
            }
            Text(pluralStringResource(R.plurals.results_count, articles.size, articles.size), style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }, empty = {
        EmptyState(Icons.Outlined.Search, stringResource(R.string.no_results_title), stringResource(R.string.no_results_body), action = stringResource(R.string.all_categories), onAction = { onQuery(""); onCategory(null) })
    })
}

@Composable
private fun BookmarksScreen(state: LegalAwarenessUiState, onBookmark: (String) -> Unit, onArticle: (String) -> Unit, onBrowse: () -> Unit, gridState: LazyGridState, modifier: Modifier = Modifier) {
    val articles = LegalContent.articles.filter { it.id in state.bookmarks }
    ArticleGrid(modifier, articles, state, onBookmark, onArticle, gridState, header = {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            ScreenHeading(stringResource(R.string.bookmarks_title), stringResource(R.string.bookmarks_description))
            Text(pluralStringResource(R.plurals.bookmark_count, articles.size, articles.size), style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }, empty = {
        if (!state.loaded) Box(Modifier.fillMaxWidth().padding(48.dp), contentAlignment = Alignment.Center) { CircularProgressIndicator() }
        else EmptyState(Icons.Outlined.BookmarkBorder, stringResource(R.string.bookmarks_empty_title), stringResource(R.string.bookmarks_empty_body), stringResource(R.string.browse_topics), onBrowse)
    })
}

@Composable
private fun ArticleGrid(
    modifier: Modifier,
    articles: List<LegalArticle>,
    state: LegalAwarenessUiState,
    onBookmark: (String) -> Unit,
    onArticle: (String) -> Unit,
    gridState: LazyGridState,
    header: @Composable () -> Unit,
    empty: @Composable () -> Unit,
) {
    BoxWithConstraints(modifier) {
        val wide = maxWidth >= 720.dp
        LazyVerticalGrid(
            columns = GridCells.Fixed(if (wide) 2 else 1),
            state = gridState,
            contentPadding = PaddingValues(horizontal = if (wide) 28.dp else 20.dp, vertical = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxSize(),
        ) {
            item(span = { GridItemSpan(maxLineSpan) }) { header() }
            if (articles.isEmpty()) item(span = { GridItemSpan(maxLineSpan) }) { empty() }
            items(articles, key = { it.id }) { article -> ArticleCard(article, state, onBookmark) { onArticle(article.id) } }
        }
    }
}

@Composable
private fun ScreenHeading(title: String, description: String) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(title, style = MaterialTheme.typography.headlineLarge, modifier = Modifier.semantics { heading() })
        Text(description, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
}

@Composable
private fun EmptyState(icon: ImageVector, title: String, body: String, action: String? = null, onAction: () -> Unit = {}, modifier: Modifier = Modifier) {
    Column(modifier.fillMaxWidth().padding(vertical = 48.dp, horizontal = 20.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(14.dp)) {
        Box(Modifier.size(80.dp).clip(CircleShape).background(MaterialTheme.colorScheme.primaryContainer), contentAlignment = Alignment.Center) { Icon(icon, null, Modifier.size(36.dp), tint = MaterialTheme.colorScheme.primary) }
        Text(title, style = MaterialTheme.typography.titleLarge, textAlign = androidx.compose.ui.text.style.TextAlign.Center)
        Text(body, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant, textAlign = androidx.compose.ui.text.style.TextAlign.Center)
        if (action != null) Button(onClick = onAction, modifier = Modifier.padding(top = 6.dp)) { Text(action) }
    }
}

@Composable
private fun ArticleScreen(article: LegalArticle, state: LegalAwarenessUiState, onBookmark: (String) -> Unit, modifier: Modifier = Modifier) {
    val category = LegalContent.categories.first { it.id == article.categoryId }
    val uriHandler = LocalUriHandler.current
    var unavailableSource by remember { mutableStateOf<String?>(null) }
    LazyColumn(modifier, contentPadding = PaddingValues(horizontal = 24.dp, vertical = 20.dp), verticalArrangement = Arrangement.spacedBy(24.dp)) {
        item {
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Surface(color = MaterialTheme.colorScheme.primaryContainer, shape = CircleShape, modifier = Modifier.weight(1f, fill = false)) {
                        Text(category.name.resolve(state.language), style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.onPrimaryContainer, modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp))
                    }
                    Spacer(Modifier.width(8.dp))
                    BookmarkButton(article.id in state.bookmarks, state.loaded) { onBookmark(article.id) }
                }
                Text(article.title.resolve(state.language), style = MaterialTheme.typography.headlineLarge, modifier = Modifier.semantics { heading() })
                Text(article.summary.resolve(state.language), style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.onSurfaceVariant)
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Icon(Icons.Outlined.Schedule, null, Modifier.size(17.dp), tint = MaterialTheme.colorScheme.onSurfaceVariant)
                    Text(stringResource(R.string.read_minutes, article.readingMinutes), style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.weight(1f))
                    Spacer(Modifier.width(6.dp))
                    OfflineBadge()
                }
                HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
            }
        }
        items(article.sections) { section ->
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(section.heading.resolve(state.language), style = MaterialTheme.typography.titleLarge, modifier = Modifier.semantics { heading() })
                Text(section.body.resolve(state.language), style = MaterialTheme.typography.bodyLarge)
            }
        }
        item {
            Surface(color = MaterialTheme.colorScheme.secondaryContainer, shape = RoundedCornerShape(18.dp)) {
                Row(Modifier.padding(18.dp), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    Icon(Icons.Outlined.Info, null, Modifier.size(22.dp), tint = MaterialTheme.colorScheme.onSecondaryContainer)
                    Text(stringResource(R.string.source_information_note), style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSecondaryContainer)
                }
            }
        }
        item {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                SectionTitle(stringResource(R.string.source_label))
                Text(stringResource(R.string.sources_description), style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                article.sources.forEach { source ->
                    Surface(onClick = {
                        try { uriHandler.openUri(source.url) } catch (_: IllegalArgumentException) { unavailableSource = source.url }
                    }, shape = RoundedCornerShape(14.dp), border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant), color = MaterialTheme.colorScheme.surfaceContainerLowest) {
                        Row(Modifier.fillMaxWidth().padding(16.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                            Text(source.title, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.weight(1f), color = MaterialTheme.colorScheme.primary)
                            Icon(Icons.Outlined.OpenInNew, stringResource(R.string.open_source), Modifier.size(18.dp), tint = MaterialTheme.colorScheme.primary)
                        }
                    }
                }
                Text(stringResource(R.string.educational_notice), style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.padding(top = 10.dp, bottom = 24.dp))
            }
        }
    }
    if (unavailableSource != null) AlertDialog(
        onDismissRequest = { unavailableSource = null },
        title = { Text(stringResource(R.string.source_unavailable_title)) },
        text = { Text(stringResource(R.string.source_unavailable_body) + "\n\n" + unavailableSource) },
        confirmButton = { TextButton(onClick = { unavailableSource = null }) { Text(stringResource(R.string.close)) } },
    )
}

@Composable
private fun HelpCard() {
    Surface(color = MaterialTheme.colorScheme.surfaceContainerLow, shape = RoundedCornerShape(20.dp)) {
        Column(Modifier.fillMaxWidth().padding(20.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Icon(Icons.Outlined.Shield, null, Modifier.size(22.dp), tint = MaterialTheme.colorScheme.primary)
                Text(stringResource(R.string.emergency_title), style = MaterialTheme.typography.titleMedium)
            }
            Text(stringResource(R.string.emergency_description), style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
            HorizontalDivider(Modifier.padding(vertical = 4.dp), color = MaterialTheme.colorScheme.outlineVariant)
            Text(stringResource(R.string.legal_aid_title), style = MaterialTheme.typography.titleMedium)
            Text(stringResource(R.string.legal_aid_description), style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}

@Composable
private fun LanguageDialog(selected: AppLanguage, onSelect: (AppLanguage) -> Unit, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        icon = { Icon(Icons.Outlined.Language, null) },
        title = { Text(stringResource(R.string.choose_language)) },
        text = {
            Column(Modifier.selectableGroup().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(stringResource(R.string.language_description), style = MaterialTheme.typography.bodyMedium)
                AppLanguage.entries.forEach { language ->
                    Row(Modifier.fillMaxWidth().clip(RoundedCornerShape(12.dp)).selectable(selected = selected == language, role = Role.RadioButton, onClick = { onSelect(language) }).padding(vertical = 8.dp, horizontal = 4.dp), verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(selected = selected == language, onClick = null)
                        Spacer(Modifier.width(14.dp))
                        Text(if (language == AppLanguage.TELUGU) "తెలుగు" else "English", style = MaterialTheme.typography.titleMedium)
                    }
                }
            }
        },
        confirmButton = { TextButton(onClick = onDismiss) { Text(stringResource(R.string.close)) } },
    )
}

@Composable
private fun AboutDialog(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        icon = { BrandMark() },
        title = { Text(stringResource(R.string.about_title)) },
        text = {
            Column(Modifier.verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(16.dp)) {
                Text(stringResource(R.string.about_description), style = MaterialTheme.typography.bodyMedium)
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    Icon(Icons.Outlined.WifiOff, null, Modifier.size(20.dp), tint = MaterialTheme.colorScheme.primary)
                    Text(stringResource(R.string.offline_description), style = MaterialTheme.typography.bodyMedium)
                }
                Text(stringResource(R.string.legal_disclaimer), style = MaterialTheme.typography.bodyMedium)
                Text(stringResource(R.string.version_label, BuildConfig.VERSION_NAME), style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        },
        confirmButton = { TextButton(onClick = onDismiss) { Text(stringResource(R.string.close)) } },
    )
}

@Preview(name = "English phone", widthDp = 390, heightDp = 844, showBackground = true)
@Composable
private fun EnglishPhonePreview() = AppPreview(AppLanguage.ENGLISH)

@Preview(name = "Telugu phone", widthDp = 390, heightDp = 844, showBackground = true)
@Composable
private fun TeluguPhonePreview() = AppPreview(AppLanguage.TELUGU)

@Preview(name = "Android tablet", widthDp = 1280, heightDp = 800, showBackground = true)
@Composable
private fun TabletPreview() = AppPreview(AppLanguage.ENGLISH)

@Composable
private fun AppPreview(language: AppLanguage) {
    LocalizedContent(language) {
        LegalAwarenessTheme {
            AppShell(
                state = LegalAwarenessUiState(language = language, loaded = true),
                saveFailed = false,
                onLanguage = {},
                onBookmark = {},
                onErrorShown = {},
            )
        }
    }
}
