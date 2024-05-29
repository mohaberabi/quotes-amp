package di

import core.data.datasource.KtorQuoteRemoteDataSource
import core.data.datasource.RoomQuoteLocalDataSource
import core.data.repository.DefaultQuoteRepository
import core.database.QuotesDb
import core.database.daos.QuotesDao
import core.domain.repository.QuoteRepository
import core.domain.source.QuoteLocalDataSource
import core.domain.source.QuoteRemoteDataSource
import core.network.util.HttpClientFactory
import io.ktor.client.HttpClient
import org.koin.dsl.module


val appModule = module {


    single<HttpClient> {
        HttpClientFactory().build()
    }
    single<QuotesDao> {
        get<QuotesDb>().quotesDao()
    }
    single<QuoteLocalDataSource> {
        RoomQuoteLocalDataSource(get())
    }

    single<QuoteRemoteDataSource> {
        KtorQuoteRemoteDataSource(get())
    }
    single<QuoteRepository> {
        DefaultQuoteRepository(get(), get())
    }
}

