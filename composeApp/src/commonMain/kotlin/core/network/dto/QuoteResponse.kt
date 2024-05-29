package core.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class QuoteResponse(
    @SerialName("qotd_date")
    val qotdDate: String,
    @SerialName("quote")
    val quote: QuoteDto
)