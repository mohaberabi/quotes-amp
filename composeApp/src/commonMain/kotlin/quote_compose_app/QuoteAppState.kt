package quote_compose_app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

data class QuoteAppState(

    val navController: NavHostController,
    val currentTop: String
)


@Composable
fun rememberQuoteAppState(
): QuoteAppState {
    val navController = rememberNavController()
    val navBackstackEntry by navController.currentBackStackEntryAsState()
    val currentTop = navBackstackEntry?.destination?.route ?: ""
    return remember(
        navController,
        currentTop,
    ) {
        QuoteAppState(
            navController = navController,
            currentTop = currentTop
        )
    }
}
