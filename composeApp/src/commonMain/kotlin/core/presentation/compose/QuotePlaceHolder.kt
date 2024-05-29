package core.presentation.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun QuotePlaceHolder(
    modifier: Modifier = Modifier,
    title: String = "Something Went Wrong ...",
    subtitle: String = "Try again..",
    onRetry: () -> Unit = {},
) {


    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {


        Text(
            title,
            fontSize = 16.sp,
            color = Color.Red,
            textAlign = TextAlign.Center,
        )

        Spacer(Modifier.height(8.dp))
        Text(
            subtitle,
            fontSize = 12.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center,
        )
        Spacer(Modifier.height(16.dp))


        QuoteButton(
            onClick = onRetry,
            label = "Try again"
        )

    }
}