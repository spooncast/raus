package club.rooftop.raus.components.badge

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import club.rooftop.raus.foundation.color.Red50

@Composable
fun DotBadge(
    modifier: Modifier = Modifier,
    size: Dp = 8.dp,
    bgColor: Color = Red50,
) {
    Box(
        modifier = modifier
            .size(size)
            .background(bgColor, CircleShape)
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewDotBadge() {
    DotBadge()
}
