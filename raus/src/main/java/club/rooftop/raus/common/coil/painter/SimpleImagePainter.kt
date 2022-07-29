package club.rooftop.raus.common.coil.painter

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest


@Composable
fun simpleImagePainter(
    @DrawableRes drawableResId: Int,
    contentScale: ContentScale = ContentScale.Crop
): Painter {
    return rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(drawableResId)
            .crossfade(true)
            .build(),
        contentScale = contentScale
    )
}
