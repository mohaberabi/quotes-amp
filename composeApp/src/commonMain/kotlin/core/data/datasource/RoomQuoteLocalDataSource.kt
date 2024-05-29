package core.data.datasource

import androidx.sqlite.SQLiteException
import core.database.daos.QuotesDao
import core.database.entity.toDomain
import core.domain.model.QuoteModel
import core.domain.model.toEntity
import core.domain.source.QuoteLocalDataSource
import core.util.AppResult
import core.util.DataError
import core.util.EmptyDataResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RoomQuoteLocalDataSource(
    private val quotesDao: QuotesDao,
) : QuoteLocalDataSource {
    override fun getSavedQuotes(): Flow<List<QuoteModel>> =
        quotesDao.getSavedQuotes().map { list -> list.map { it.toDomain() } }

    override suspend fun saveQuote(quote: QuoteModel): EmptyDataResult<DataError> {

        return try {
            quotesDao.saveQuote(quote.toEntity())
            AppResult.Done(Unit)
        } catch (e: SQLiteException) {
            e.printStackTrace()
            AppResult.Error(DataError.Local.DISK_FULL)
        } catch (e: Exception) {
            e.printStackTrace()
            AppResult.Error(DataError.Local.UNKNOWN)

        }

    }

}