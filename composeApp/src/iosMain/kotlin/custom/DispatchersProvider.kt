package custom

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

actual class DispatchersProvider {

    actual val main: CoroutineDispatcher = Dispatchers.Main
    actual val default: CoroutineDispatcher = Dispatchers.Default
    actual val io: CoroutineDispatcher = Dispatchers.IO
    actual val unconfined: CoroutineDispatcher = Dispatchers.Unconfined
}