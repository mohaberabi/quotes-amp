package core.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun QuoteTheme(
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = quoteColors,
        content = content,
        typography = uiTypography
    )

}