package core.domain.model

import core.database.entity.QuoteEntity

data class QuoteModel(
    val id: Int,
    val body: String,
    val author: String,
    val saved: Boolean = false,
)


fun QuoteModel.toEntity(): QuoteEntity = QuoteEntity(null, author, body, saved)