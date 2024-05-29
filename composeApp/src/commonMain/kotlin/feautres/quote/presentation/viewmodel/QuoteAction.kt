package feautres.quote.presentation.viewmodel

sealed interface QuoteAction {


    data object OnGetQuote : QuoteAction
}