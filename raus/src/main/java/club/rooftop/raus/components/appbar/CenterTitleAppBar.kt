package club.rooftop.raus.components.appbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CenterTitleAppBar(
    backgroundColor: Color = MaterialTheme.colors.background,
    contentColor: Color = MaterialTheme.colors.onBackground,
    title: String? = null,
    backIcon: ImageVector? = null,
    onBackClickListener: () -> Unit = {},
    postArea: @Composable ((Modifier) -> Unit)? = null,
) {
    Box(
        modifier = Modifier
            .background(color = backgroundColor)
            .fillMaxWidth()
            .height(52.dp),
    ) {
        if (backIcon != null) {
            IconButton(
                modifier = Modifier.align(Alignment.CenterStart),
                onClick = onBackClickListener
            ) {
                Icon(
                    modifier = Modifier.height(28.dp),
                    imageVector = backIcon,
                    contentDescription = "app bar back button icon",
                    tint = contentColor
                )
            }
        }
        if (title != null) {
            Text(
                modifier = Modifier.align(Alignment.Center)
                    .padding(start=4.dp)
                    .widthIn(max = 184.dp),
                text = title,
                textAlign = TextAlign.Center,
                color = contentColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }

        postArea?.invoke(
            Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 16.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun PreviewCenterAppBar() {
    CenterTitleAppBar(title = "Title")
}