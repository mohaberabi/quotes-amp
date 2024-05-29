package quote_compose_app

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import core.presentation.QuoteNavHost
import core.presentation.compose.QuoteBotomNav
import core.presentation.navigateBottom
import core.theme.QuoteTheme


@Composable
fun QuoteComposeApp() {
    val state = rememberQuoteAppState()

    QuoteTheme {


        Scaffold(bottomBar = {
            QuoteBotomNav(
                onChanged = {
                    state.navController.navigateBottom(it)
                },
                top = state.currentTop
            )
        }) {
            QuoteNavHost(
                modifier = Modifier.padding(it),
                navController = state.navController
            )

        }


    }


}