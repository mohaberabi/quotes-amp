package custom


import core.database.QuotesDb
import database.getQuoteDb
import org.koin.dsl.module

actual val customModule = module {
    single<QuotesDb> {

        getQuoteDb()
    }
}
