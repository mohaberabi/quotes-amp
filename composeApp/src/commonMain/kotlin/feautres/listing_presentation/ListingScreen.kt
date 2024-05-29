package feautres.listing_presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import core.presentation.compose.QuoteCard
import di.koinViewModel


@Composable
fun ListingScreenRoot(
    modifier: Modifier = Modifier,
    viewModel: ListingViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsState()
    ListingScreen(
        modifier = modifier,
        state = state
    )
}


@Composable
fun ListingScreen(
    modifier: Modifier = Modifier,
    state: ListingState,
) {
    LazyVerticalStaggeredGrid(
        modifier = modifier,
        columns = StaggeredGridCells.Fixed(2),
        verticalItemSpacing = 8.dp,
        contentPadding = PaddingValues(6.dp)
    ) {

        items(state.quotes) { item ->
            QuoteCard(quote = item)
        }

    }

}