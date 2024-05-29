package database


import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import core.database.QuotesDb
import platform.Foundation.NSHomeDirectory

fun getQuoteDb(): QuotesDb {
    val dbFile = NSHomeDirectory() + "/quote.db"
    return Room.databaseBuilder<QuotesDb>(
        name = dbFile,
        factory = { QuotesDb::class.instantiateImpl() }
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}