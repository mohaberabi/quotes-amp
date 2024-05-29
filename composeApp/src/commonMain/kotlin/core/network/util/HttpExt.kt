package core.network.util

import core.util.AppResult
import core.util.DataError
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.coroutines.CancellationException
import kotlinx.serialization.SerializationException

suspend inline fun <reified Response : Any> HttpClient.get(
    path: String,
    queryParameters: Map<String, Any?> = mapOf(),
): AppResult<Response, DataError.Network> {

    return safeCall {
        get {
            url(constructRoute(path))
            queryParameters.forEach { (key, value) ->
                parameter(key, value)
            }
        }
    }
}

//    crossinline block: HttpRequestBuilder.() -> Unit = {},
suspend inline fun <reified Response : Any> HttpClient.delete(
    route: String,
    queryParams: Map<String, Any?> = mapOf(),
): AppResult<Response, DataError.Network> {
    return safeCall {
        delete {
            url(constructRoute(route))
            queryParams.forEach { (key, value) ->
                parameter(key, value)
            }
        }
    }
}

suspend inline fun <reified Request, reified Response : Any> HttpClient.post(
    route: String,
    body: Request,
    crossinline block: HttpRequestBuilder.() -> Unit = {},
): AppResult<Response, DataError.Network> {

    return safeCall {
        post {
            url(constructRoute(route))
            setBody(body)
            block()
        }
    }
}

suspend inline fun <reified T> safeCall(
    execute: () -> HttpResponse,
): AppResult<T, DataError.Network> {

    val response = try {
        execute()
    } catch (e: UnresolvedAddressException) {
        e.printStackTrace()
        return AppResult.Error(DataError.Network.NO_NETWORK)
    } catch (e: SerializationException) {
        e.printStackTrace()
        return AppResult.Error(DataError.Network.SERIALIZATION_ERROR)

    } catch (e: Exception) {
        if (e is CancellationException) {
            throw e
        } else {
            return AppResult.Error(DataError.Network.UNKNOWN_ERROR)
        }
    }
    return mapResponseToAppResult(response)
}


suspend inline fun <reified T> mapResponseToAppResult(
    response: HttpResponse,
): AppResult<T, DataError.Network> {
    return when (response.status.value) {
        in 200..299 -> AppResult.Done(response.body<T>())
        401 -> AppResult.Error(DataError.Network.UNAUTHORIZED)
        408 -> AppResult.Error(DataError.Network.REQUEST_TIMEOUT)
        409 -> AppResult.Error(DataError.Network.CONFLICT)
        413 -> AppResult.Error(DataError.Network.PAYLOAD_TOO_LARGE)
        429 -> AppResult.Error(DataError.Network.TOO_MANY_REQUEST)
        in 500..599 -> AppResult.Error(DataError.Network.SERVER_ERROR)
        else -> AppResult.Error(DataError.Network.UNKNOWN_ERROR)

    }
}


fun constructRoute(route: String): String {


    return when {
        route.contains(EndPoints.BASE_URL) -> route
        route.startsWith("/") -> EndPoints.BASE_URL + route
        else -> EndPoints.BASE_URL + "/$route"

    }
}

