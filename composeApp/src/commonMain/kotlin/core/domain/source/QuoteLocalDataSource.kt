package core.domain.source

import core.domain.model.QuoteModel
import core.util.DataError
import core.util.EmptyDataResult
import kotlinx.coroutines.flow.Flow

interface QuoteLocalDataSource {


    fun getSavedQuotes(): Flow<List<QuoteModel>>


    suspend fun saveQuote(quote: QuoteModel): EmptyDataResult<DataError>


}