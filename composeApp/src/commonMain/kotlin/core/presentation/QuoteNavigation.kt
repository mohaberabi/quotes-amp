package core.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import feautres.listing_presentation.ListingScreenRoot
import feautres.quote.presentation.viewmodel.QuoteScreenRoot


@Composable
fun QuoteNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = QuoteRoutes.QUOTE_ROUTE
    ) {
        quoteScreen()
        listingScreen()

    }
}


fun NavGraphBuilder.quoteScreen(
    modifier: Modifier = Modifier,
) =
    composable(QuoteRoutes.QUOTE_ROUTE) {
        QuoteScreenRoot(
            modifier = modifier
        )
    }

fun NavGraphBuilder.listingScreen(
    modifier: Modifier = Modifier,
) = composable(QuoteRoutes.LISTING_ROUTE) { ListingScreenRoot(modifier = modifier) }

fun NavController.navigateBottom(
    to: String,
) = navigate(to) {
    popUpTo(currentDestination?.route ?: to) {
        inclusive = true
        saveState = true
    }
    restoreState = true
}