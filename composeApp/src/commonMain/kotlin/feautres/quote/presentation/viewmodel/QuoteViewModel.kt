package feautres.quote.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import core.domain.repository.QuoteRepository
import core.util.AppResult
import core.util.asUiText
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class QuoteViewModel(
    private val quoteRepository: QuoteRepository,
) : ViewModel() {


    private val _state = MutableStateFlow<QuoteState>(QuoteState.Initial)


    val state = _state.asStateFlow()

    init {
        getInitialQuote()
    }


    private fun getInitialQuote() {
        _state.update { QuoteState.Loading }
        viewModelScope.launch {
            when (val res = quoteRepository.getQuoteOfDay()) {
                is AppResult.Done -> _state.update { QuoteState.Done(res.data) }
                is AppResult.Error -> {
                    val list = quoteRepository.getSavedQuotes().first()
                    if (list.isEmpty()) {
                        _state.update { QuoteState.Error(res.error.asUiText()) }
                    } else {
                        _state.update { QuoteState.Done(list.random()) }

                    }
                }
            }
        }
    }

    fun onAction(action: QuoteAction) {
        when (action) {
            QuoteAction.OnGetQuote -> getQuoteOfDay()
        }
    }

    private fun getQuoteOfDay() {
        _state.update { QuoteState.Loading }
        viewModelScope.launch {
            when (val res = quoteRepository.getQuoteOfDay()) {
                is AppResult.Done -> _state.update { QuoteState.Done(res.data) }
                is AppResult.Error -> _state.update { QuoteState.Error(res.error.asUiText()) }
            }
        }

    }


}