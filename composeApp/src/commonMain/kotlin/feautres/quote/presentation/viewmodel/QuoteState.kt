package feautres.quote.presentation.viewmodel

import core.domain.model.QuoteModel
import core.util.UiText

sealed interface QuoteState {


    data object Initial : QuoteState

    data object Loading : QuoteState

    data class Error(val error: UiText) : QuoteState

    data class Done(val quote: QuoteModel) : QuoteState
}