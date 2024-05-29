package custom

import kotlinx.coroutines.CoroutineDispatcher

expect class DispatchersProvider {

    val main: CoroutineDispatcher
    val default: CoroutineDispatcher
    val io: CoroutineDispatcher
    val unconfined: CoroutineDispatcher
}