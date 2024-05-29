package core.data.repository

import core.domain.model.QuoteModel
import core.domain.model.toEntity
import core.domain.repository.QuoteRepository
import core.domain.source.QuoteLocalDataSource
import core.domain.source.QuoteRemoteDataSource
import core.util.AppResult
import core.util.DataError
import core.util.EmptyDataResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DefaultQuoteRepository(
    private val quoteRemoteDataSource: QuoteRemoteDataSource,
    private val quoteLocalDataSource: QuoteLocalDataSource

) : QuoteRepository {

    override fun getSavedQuotes(): Flow<List<QuoteModel>> = quoteLocalDataSource.getSavedQuotes()

    override suspend fun getQuoteOfDay(): AppResult<QuoteModel, DataError> {
        return when (val remoteRes = quoteRemoteDataSource.getQuoteOfTheDay()) {
            is AppResult.Done -> {
                quoteLocalDataSource.saveQuote(remoteRes.data)
                remoteRes
            }

            is AppResult.Error -> remoteRes
        }
    }

}