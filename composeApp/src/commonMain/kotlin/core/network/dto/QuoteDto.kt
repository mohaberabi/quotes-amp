package core.network.dto

import core.domain.model.QuoteModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuoteDto(
    @SerialName("author")
    val author: String,
    @SerialName("body")
    val body: String,
    @SerialName("id")
    val id: Int,
)


fun QuoteDto.toDomain(): QuoteModel = QuoteModel(
    id = id,
    author = author,
    body = body
)