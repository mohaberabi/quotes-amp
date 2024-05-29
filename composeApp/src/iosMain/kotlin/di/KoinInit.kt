package di

import custom.customModule
import org.koin.core.context.startKoin


actual class KoinInit {
    actual fun init() {

        startKoin {

            modules(
                customModule,
                appModule,
                viewModelModule,
            )
        }
    }

}



