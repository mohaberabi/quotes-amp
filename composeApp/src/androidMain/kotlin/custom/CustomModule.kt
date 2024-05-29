package custom

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import core.database.QuotesDb
import org.koin.dsl.module


actual val customModule = module {
    single {
        createDatabase(get())
    }
}

fun createDatabase(context: Context)
        : QuotesDb {
    val dbFile = context.getDatabasePath("quote.db")
    return Room.databaseBuilder<QuotesDb>(
        context = context,
        name = dbFile.absolutePath,
    ).setDriver(BundledSQLiteDriver()).build()
}
