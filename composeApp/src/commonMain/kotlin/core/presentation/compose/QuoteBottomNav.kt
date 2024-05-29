package core.presentation.compose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import core.presentation.QuoteRoutes


data class QuoteNavItem(
    val title: String,
    val route: String,
    val icon: ImageVector,
)

val defaultQuoteBottomItems = listOf(
    QuoteNavItem(
        title = "Quote of day",
        route = QuoteRoutes.QUOTE_ROUTE,
        icon = Icons.Default.DateRange
    ),
    QuoteNavItem(
        title = "Quotes",
        route = QuoteRoutes.LISTING_ROUTE,
        icon = Icons.AutoMirrored.Filled.List
    )
)

@Composable
fun QuoteBotomNav(
    modifier: Modifier = Modifier,
    top: String,
    onChanged: (String) -> Unit,
) {


    BottomAppBar(

        containerColor = MaterialTheme.colorScheme.primary,

        modifier = modifier,
    ) {
        defaultQuoteBottomItems.forEach { item ->
            NavigationBarItem(
                colors = NavigationBarItemColors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedIndicatorColor = MaterialTheme.colorScheme.onPrimary,
                    unselectedIconColor = Color.Gray,
                    unselectedTextColor = Color.Gray,
                    selectedTextColor = MaterialTheme.colorScheme.onPrimary,
                    disabledIconColor = Color.Transparent,
                    disabledTextColor = Color.Transparent,
                ),
                label = {
                    Text(item.title)
                },
                onClick = { onChanged(item.route) },
                selected = item.route == top,
                icon = {
                    Icon(
                        item.icon,
                        contentDescription = item.title
                    )
                }
            )
        }

    }

}