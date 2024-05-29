package core.presentation.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import core.theme.quoteTypography
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import quotes.composeapp.generated.resources.Res
import quotes.composeapp.generated.resources.app_nam
import quotes.composeapp.generated.resources.logo


@OptIn(ExperimentalResourceApi::class)
@Composable
fun QuoteLogo(modifier: Modifier = Modifier) {

    Row {

        Image(
            painterResource(
                Res.drawable.logo,
            ),
            contentDescription = "logo",
            modifier = modifier.size(36.dp),
        )


        Spacer(modifier = Modifier.width(8.dp))

        Text(
            stringResource(Res.string.app_nam),
            style = quoteTypography.displaySmall.copy(color = MaterialTheme.colorScheme.onPrimary),
        )

    }

}