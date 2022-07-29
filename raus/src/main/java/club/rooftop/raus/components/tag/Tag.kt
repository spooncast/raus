package club.rooftop.raus.components.tag

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import club.rooftop.raus.foundation.color.Black
import club.rooftop.raus.foundation.color.Gray10
import club.rooftop.raus.foundation.typography.Body1Regular
import club.rooftop.raus.foundation.typography.SubheadRegular

@Composable
fun Tag(
    modifier: Modifier = Modifier,
    size: TagSize = TagSize.L,
    text: String,
    backgroundColor: Color = Gray10,
    contentColor: Color = Black,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(size.height),
        elevation = ButtonDefaults.elevation(0.dp, 0.dp, 0.dp, 0.dp, 0.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            contentColor = contentColor,
        ),
        contentPadding = PaddingValues(horizontal = size.horizontalInnerPadding),
    ) {
        Text(
            text = text,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = size.textStyle
        )
    }
}

enum class TagSize(
    val horizontalInnerPadding: Dp,
    val height: Dp,
    val textStyle: TextStyle,
) {
    L(12.dp, 40.dp, SubheadRegular),
    M(12.dp, 34.dp, Body1Regular),
    S(8.dp, 26.dp, Body1Regular),
}

@Preview(showBackground = true)
@Composable
fun PreviewSolidTag() {
    Tag(text = "Keyword", size = TagSize.L) {

    }
    Tag(text = "Keyword", size = TagSize.M) {

    }
    Tag(text = "Keyword", size = TagSize.S) {

    }
}
