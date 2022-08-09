package club.rooftop.demo.ui.image

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import club.rooftop.demo.R
import club.rooftop.raus.common.HorizontalSpacer
import club.rooftop.raus.common.VerticalSpacer
import club.rooftop.raus.components.image.SquircleImage
import coil.request.ImageRequest

@Composable
fun ImageScreen() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        Text("128 Squircle Image")

        Row {
            SquircleImage(
                imageRequest = ImageRequest.Builder(LocalContext.current)
                    .data(R.drawable.sample_photo)
                    .crossfade(true)
                    .placeholder(R.drawable.ic_group)
                    .error(R.drawable.ic_group)
                    .build(),
                size = 128.dp
            )

            HorizontalSpacer(size = 8.dp)

            SquircleImage(
                imageRequest = ImageRequest.Builder(LocalContext.current)
                    .data(null)
                    .crossfade(true)
                    .placeholder(R.drawable.ic_group)
                    .error(R.drawable.ic_group)
                    .build(),
                size = 128.dp
            )
        }


        VerticalSpacer(size = 8.dp)

        Text("64 Squircle Image")

        Row {
            SquircleImage(
                imageRequest = ImageRequest.Builder(LocalContext.current)
                    .data(R.drawable.sample_photo)
                    .crossfade(true)
                    .placeholder(R.drawable.ic_group)
                    .error(R.drawable.ic_group)
                    .build(),
                size = 64.dp
            )

            HorizontalSpacer(size = 8.dp)

            SquircleImage(
                imageRequest = ImageRequest.Builder(LocalContext.current)
                    .data(null)
                    .crossfade(true)
                    .placeholder(R.drawable.ic_group)
                    .error(R.drawable.ic_group)
                    .build(),
                size = 64.dp
            )
        }

    }
}