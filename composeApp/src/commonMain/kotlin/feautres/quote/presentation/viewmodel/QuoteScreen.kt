package feautres.quote.presentation.viewmodel

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import core.presentation.compose.QuoteAppBar
import core.presentation.compose.QuoteBox
import core.presentation.compose.QuoteLoader
import core.presentation.compose.QuoteLogo
import core.presentation.compose.QuotePlaceHolder
import di.koinViewModel


@Composable
fun QuoteScreenRoot(
    modifier: Modifier = Modifier,
    viewModel: QuoteViewModel = koinViewModel()
) {

    val state by viewModel.state.collectAsState()
    QuoteScreen(
        state = state,
        modifier = modifier,
        onAction = viewModel::onAction
    )
}


@Composable
fun QuoteScreen(
    modifier: Modifier = Modifier,
    state: QuoteState,
    onAction: (QuoteAction) -> Unit,
) {


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        QuoteAppBar(
            title = {

                QuoteLogo()

            },
            actions = {
                IconButton(
                    onClick = {
                        onAction(QuoteAction.OnGetQuote)
                    },
                ) {
                    Icon(
                        Icons.Default.Refresh,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onPrimary,
                    )
                }
            }
        )
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

          
            item {
                when (state) {
                    is QuoteState.Done -> QuoteBox(
                        modifier = Modifier
                            .fillMaxSize(),
                        quote = state.quote,
                    )

                    is QuoteState.Error -> QuotePlaceHolder(onRetry = { onAction(QuoteAction.OnGetQuote) })
                    QuoteState.Loading -> QuoteLoader()
                    else -> Unit
                }
            }
        }
    }


}