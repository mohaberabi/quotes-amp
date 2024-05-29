package core.data.datasource

import core.domain.model.QuoteModel
import core.domain.source.QuoteRemoteDataSource
import core.network.dto.QuoteDto
import core.network.dto.QuoteResponse
import core.network.dto.toDomain
import core.network.util.EndPoints
import core.network.util.get
import core.util.AppResult
import core.util.DataError
import core.util.map
import io.ktor.client.HttpClient

class KtorQuoteRemoteDataSource(
    private val httpClient: HttpClient,
) : QuoteRemoteDataSource {
    override suspend fun getQuoteOfTheDay(): AppResult<QuoteModel, DataError.Network> =
        httpClient.get<QuoteResponse>(EndPoints.BASE_URL).map { it.quote.toDomain() }
}