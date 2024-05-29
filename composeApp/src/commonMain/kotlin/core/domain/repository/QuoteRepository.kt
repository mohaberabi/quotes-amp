package core.domain.repository

import core.domain.model.QuoteModel
import core.util.AppResult
import core.util.DataError
import core.util.EmptyDataResult
import kotlinx.coroutines.flow.Flow

interface QuoteRepository {


    fun getSavedQuotes(): Flow<List<QuoteModel>>
    suspend fun getQuoteOfDay(): AppResult<QuoteModel, DataError>

}