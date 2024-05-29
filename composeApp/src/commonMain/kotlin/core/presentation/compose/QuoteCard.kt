package core.presentation.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import core.domain.model.QuoteModel
import core.theme.quoteTypography


@Composable
fun QuoteCard(
    modifier: Modifier = Modifier,
    quote: QuoteModel,
) {

    ElevatedCard(
        modifier = modifier
            .padding(8.dp),
    ) {


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                quote.body,
                modifier = Modifier.padding(12.dp),
                style = quoteTypography.titleLarge
            )
            Text(
                quote.author,
                textAlign = TextAlign.Center,
                style = quoteTypography.bodySmall,
                modifier = Modifier.padding(bottom = 4.dp),
            )
        }
    }

}