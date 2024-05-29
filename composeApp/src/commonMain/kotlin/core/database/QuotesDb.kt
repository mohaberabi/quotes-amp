package core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import core.database.daos.QuotesDao
import core.database.entity.QuoteEntity


@Database(entities = [QuoteEntity::class], version = 1, exportSchema = false)
abstract class QuotesDb : RoomDatabase() {

    abstract fun quotesDao(): QuotesDao
}