package core.presentation.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import core.domain.model.QuoteModel
import core.theme.quoteTypography


@Composable
fun QuoteLoader(modifier: Modifier = Modifier) {


    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {


        CircularProgressIndicator()
        Text(
            loadingQuote.body,
            style = quoteTypography.titleMedium

        )
        Text(
            loadingQuote.author,
            style = quoteTypography.bodyLarge
        )
    }
}

private val loadingQuote = QuoteModel(
    id = -1,
    body = "Believe me you know nothing about waiting",
    author = "Gradle"
)