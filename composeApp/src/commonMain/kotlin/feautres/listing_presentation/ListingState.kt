package feautres.listing_presentation

import core.domain.model.QuoteModel

data class ListingState(
    val quotes: List<QuoteModel> = listOf()
)
