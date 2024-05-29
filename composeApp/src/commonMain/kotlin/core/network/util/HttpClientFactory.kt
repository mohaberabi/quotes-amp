package core.network.util

import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest

import io.ktor.client.HttpClient
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class HttpClientFactory {
    fun build(): HttpClient {
        return HttpClient {


            install(ContentNegotiation) {
                json(
                    json = Json {
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true
                    },
                )
            }
//            install(Logging) {
//                level = LogLevel.ALL
//                logger = object : io.ktor.client.plugins.logging.Logger {
//                    override fun log(message: String) {
//                        val lg = logging("ktor")
//                        lg.i { message }
//                    }
//                }
//            }
            defaultRequest {
                contentType(ContentType.Application.Json)
            }
        }
    }
}