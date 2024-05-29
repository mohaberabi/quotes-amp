package di

import android.content.Context
import custom.customModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

actual class KoinInit(
    private val context: Context,
) {
    actual fun init() {
        startKoin {
            androidContext(context)
            androidLogger()
            modules(
                customModule,
                appModule,
                viewModelModule
            )
        }
    }


}

