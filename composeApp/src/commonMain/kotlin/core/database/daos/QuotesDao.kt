package core.database.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import core.database.entity.QuoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface QuotesDao {
    @Query("SELECT * FROM quote")
    fun getSavedQuotes(): Flow<List<QuoteEntity>>

    @Upsert
    suspend fun saveQuote(quote: QuoteEntity)

}