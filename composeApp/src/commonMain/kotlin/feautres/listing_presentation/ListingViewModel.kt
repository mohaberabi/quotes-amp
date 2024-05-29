package feautres.listing_presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import core.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlin.time.Duration.Companion.seconds

class ListingViewModel(
    private val quoteRepository: QuoteRepository,
) : ViewModel() {
    val state = quoteRepository.getSavedQuotes().map {
        ListingState(it)
    }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5.seconds.inWholeMilliseconds),
            ListingState()
        )

}