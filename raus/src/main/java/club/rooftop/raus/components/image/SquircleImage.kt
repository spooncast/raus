package club.rooftop.raus.components.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import club.rooftop.raus.foundation.color.Gray10
import club.rooftop.raus.foundation.color.Gray20
import club.rooftop.raus.foundation.shape.SquircleShape
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

@Composable
fun SquircleImage(
    modifier: Modifier = Modifier,
    imageRequest: ImageRequest,
    size: Dp,
    backgroundColor: Color = Gray10,
    borderColor: Color = Gray20,
    borderSize: Dp = 0.5.dp,
) {
    Box(
        modifier = modifier
            .size(size)
            .clip(SquircleShape)
            .background(borderColor),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                model = imageRequest,
                contentScale = ContentScale.Crop
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(SquircleShape)
                .background(backgroundColor)
                .size(size - borderSize - borderSize),
        )
    }
}
