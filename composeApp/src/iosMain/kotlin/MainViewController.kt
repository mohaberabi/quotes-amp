import androidx.compose.ui.window.ComposeUIViewController
import di.KoinInit
import quote_compose_app.QuoteComposeApp

fun MainViewController() = ComposeUIViewController(
    configure = {

        KoinInit().init()
    },
) {
    QuoteComposeApp()
}