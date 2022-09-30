package club.rooftop.raus.components.badge

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import club.rooftop.raus.foundation.color.Red50
import club.rooftop.raus.foundation.color.White
import club.rooftop.raus.foundation.typography.Body2BoldCenter

@Composable
fun Badge(
    modifier: Modifier = Modifier,
    text: String,
    bgColor: Color = Red50,
    contentColor: Color = White
) {
    Box(
        modifier = modifier
            .height(20.dp)
            .background(bgColor, RoundedCornerShape(38.dp))
            .padding(horizontal = 6.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = contentColor,
            style = Body2BoldCenter
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBadge() {
    Badge(text = "10")
}
