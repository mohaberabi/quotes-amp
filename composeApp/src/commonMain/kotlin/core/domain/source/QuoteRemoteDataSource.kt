package core.domain.source

import core.domain.model.QuoteModel
import core.util.AppResult
import core.util.DataError

interface QuoteRemoteDataSource {
    suspend fun getQuoteOfTheDay(): AppResult<QuoteModel, DataError.Network>
}