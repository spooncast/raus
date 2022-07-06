package club.rooftop.raus.components.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import club.rooftop.raus.common.HorizontalSpacer
import club.rooftop.raus.foundation.color.Purple50
import club.rooftop.raus.foundation.typography.Body1Bold
import club.rooftop.raus.foundation.typography.SubheadBold


@Composable
fun SolidButton(
    modifier: Modifier = Modifier,
    size: ButtonSize = ButtonSize.L,
    @DrawableRes preVectorImgRes: Int? = null,
    backgroundColor: Color = Purple50,
    contentColor: Color = White,
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(size.height),
        elevation = ButtonDefaults.elevation(0.dp, 0.dp, 0.dp, 0.dp, 0.dp),
        shape = RoundedCornerShape(45.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            contentColor = contentColor,
        ),
        contentPadding = PaddingValues(horizontal = size.horizontalInnerPadding),
    ) {
        if (preVectorImgRes != null) {
            Icon(
                ImageVector.vectorResource(id = preVectorImgRes),
                contentDescription = text,
                tint = contentColor
            )

            HorizontalSpacer(size = 4.dp)
        }

        Text(
            text = text,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = if (size == ButtonSize.L) SubheadBold else Body1Bold
        )
    }
}

enum class ButtonSize(
    val horizontalInnerPadding: Dp,
    val height: Dp
) {
    L(16.dp, 52.dp),
    M(16.dp, 40.dp),
    S(10.dp, 34.dp),
}

enum class ButtonType {
    Text,
    Solid,
    Outlined
}

@Preview(showBackground = true)
@Composable
fun PreviewSolidButton() {
    SolidButton(text = "Button") {

    }
}
