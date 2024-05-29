package core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import core.domain.model.QuoteModel


@Entity(
    tableName = "quote"
)
data class QuoteEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int? = null,
    val author: String,
    val body: String,
    val saved: Boolean = false
)

fun QuoteEntity.toDomain(): QuoteModel = QuoteModel(
    id = id ?: 0,
    author = author,
    body = body,
    saved = saved
)