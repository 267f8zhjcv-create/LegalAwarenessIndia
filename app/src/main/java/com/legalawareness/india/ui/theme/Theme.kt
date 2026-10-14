package com.legalawareness.india.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val LightColors = lightColorScheme(
    primary = Color(0xFF145E52),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFDCEEE6),
    onPrimaryContainer = Color(0xFF143E35),
    secondary = Color(0xFF936A38),
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFF7ECD9),
    onSecondaryContainer = Color(0xFF584025),
    tertiary = Color(0xFF586997),
    tertiaryContainer = Color(0xFFE7EBFA),
    onTertiaryContainer = Color(0xFF2D3C66),
    background = Color(0xFFFAFAF6),
    onBackground = Color(0xFF202B27),
    surface = Color(0xFFFAFAF6),
    onSurface = Color(0xFF202B27),
    surfaceVariant = Color(0xFFECEFE8),
    onSurfaceVariant = Color(0xFF5A665F),
    outline = Color(0xFF77857D),
    outlineVariant = Color(0xFFDDE3DB),
    surfaceContainerLowest = Color.White,
    surfaceContainerLow = Color(0xFFF3F5EF),
    surfaceContainer = Color(0xFFEDF1E9),
    surfaceContainerHigh = Color(0xFFE6ECE3),
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFF9BD5BD),
    onPrimary = Color(0xFF00382C),
    primaryContainer = Color(0xFF1A4D40),
    onPrimaryContainer = Color(0xFFDCEEE6),
    secondary = Color(0xFFE1C28E),
    secondaryContainer = Color(0xFF4B3921),
    onSecondaryContainer = Color(0xFFF7ECD9),
    tertiary = Color(0xFFB5C5EF),
    tertiaryContainer = Color(0xFF303F64),
    onTertiaryContainer = Color(0xFFE7EBFA),
    background = Color(0xFF111A16),
    onBackground = Color(0xFFE4EBE4),
    surface = Color(0xFF111A16),
    onSurface = Color(0xFFE4EBE4),
    surfaceVariant = Color(0xFF283C31),
    onSurfaceVariant = Color(0xFFB6C5BB),
    outline = Color(0xFF81968A),
    outlineVariant = Color(0xFF354B3E),
    surfaceContainerLowest = Color(0xFF0C1511),
    surfaceContainerLow = Color(0xFF18231D),
    surfaceContainer = Color(0xFF203027),
    surfaceContainerHigh = Color(0xFF293C31),
)

private val AppTypography = Typography(
    displaySmall = TextStyle(fontFamily = FontFamily.Default, fontWeight = FontWeight.SemiBold, fontSize = 34.sp, lineHeight = 43.sp, letterSpacing = (-0.6).sp),
    headlineLarge = TextStyle(fontFamily = FontFamily.Default, fontWeight = FontWeight.SemiBold, fontSize = 30.sp, lineHeight = 40.sp),
    headlineMedium = TextStyle(fontFamily = FontFamily.Default, fontWeight = FontWeight.SemiBold, fontSize = 26.sp, lineHeight = 36.sp),
    headlineSmall = TextStyle(fontFamily = FontFamily.Default, fontWeight = FontWeight.SemiBold, fontSize = 22.sp, lineHeight = 31.sp),
    titleLarge = TextStyle(fontFamily = FontFamily.Default, fontWeight = FontWeight.SemiBold, fontSize = 20.sp, lineHeight = 29.sp),
    titleMedium = TextStyle(fontFamily = FontFamily.Default, fontWeight = FontWeight.SemiBold, fontSize = 16.sp, lineHeight = 25.sp),
    bodyLarge = TextStyle(fontFamily = FontFamily.Default, fontSize = 16.sp, lineHeight = 28.sp),
    bodyMedium = TextStyle(fontFamily = FontFamily.Default, fontSize = 14.sp, lineHeight = 23.sp),
    labelLarge = TextStyle(fontFamily = FontFamily.Default, fontWeight = FontWeight.Medium, fontSize = 14.sp, lineHeight = 22.sp),
    labelSmall = TextStyle(fontFamily = FontFamily.Default, fontWeight = FontWeight.SemiBold, fontSize = 11.sp, lineHeight = 17.sp, letterSpacing = 0.6.sp),
)

@Composable
fun LegalAwarenessTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) DarkColors else LightColors,
        typography = AppTypography,
        content = content,
    )
}
