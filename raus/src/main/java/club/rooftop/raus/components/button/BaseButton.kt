package club.rooftop.raus.components.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import club.rooftop.raus.common.HorizontalSpacer
import club.rooftop.raus.foundation.color.Gray10
import club.rooftop.raus.foundation.color.Gray20
import club.rooftop.raus.foundation.color.Gray30
import club.rooftop.raus.foundation.color.Gray90
import club.rooftop.raus.foundation.color.Purple50
import club.rooftop.raus.foundation.color.Purple60
import club.rooftop.raus.foundation.typography.Body1Bold
import club.rooftop.raus.foundation.typography.SubheadBold

private val buttonShape: Shape by lazy { RoundedCornerShape(45.dp) }

@Composable
internal fun BaseButton(
    modifier: Modifier,
    size: ButtonSize,
    type: ButtonTypes,
    @DrawableRes preVectorImgRes: Int?,
    text: String,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val color = if (isPressed) type.pressedColor else type.buttonColor
    val borderColor = if (type is ButtonTypes.Outlined) type.borderColor else color
    Row(
        modifier = modifier
            .height(size.height)
            .clip(buttonShape)
            .background(color, buttonShape)
            .border(1.dp, borderColor, buttonShape)
            .clickable(
                indication = null,
                interactionSource = interactionSource
            ) {
                onClick()
            }
            .padding(PaddingValues(horizontal = size.horizontalInnerPadding)),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (preVectorImgRes != null) {
            Icon(
                ImageVector.vectorResource(id = preVectorImgRes),
                contentDescription = text,
                modifier = Modifier.size(size.iconSize),
                tint = type.contentColor,
            )

            HorizontalSpacer(size = 2.dp)
        }

        Text(
            text = text,
            color = type.contentColor,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = if (size == ButtonSize.L) SubheadBold else Body1Bold
        )
    }
}

enum class ButtonSize(
    val horizontalInnerPadding: Dp,
    val height: Dp,
    val iconSize: Dp,
) {
    L(16.dp, 52.dp, 28.dp),
    M(16.dp, 40.dp, 20.dp),
    S(10.dp, 34.dp, 20.dp),
}

sealed class ButtonTypes(
    open val buttonColor: Color = Purple50,
    open val pressedColor: Color = Purple60,
    open val contentColor: Color = White,
) {
    data class Solid(
        override val buttonColor: Color = Purple50,
        override val pressedColor: Color = Purple60,
        override val contentColor: Color = White,
    ): ButtonTypes(buttonColor, pressedColor, contentColor)

    data class Outlined(
        override val buttonColor: Color = Transparent,
        override val pressedColor: Color = Gray20,
        override val contentColor: Color = Gray90,
        val borderColor: Color = Gray30,
    ): ButtonTypes(buttonColor, pressedColor, contentColor)

    object Text: ButtonTypes()
}

@Preview(showBackground = true)
@Composable
fun PreviewSolidButton() {
    SolidButton(text = "Button") {

    }
}