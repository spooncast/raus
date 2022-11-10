package club.rooftop.raus.components.button

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun SolidButton(
    modifier: Modifier = Modifier,
    size: ButtonSize = ButtonSize.L,
    type: ButtonTypes.Solid = ButtonTypes.Solid(),
    @DrawableRes preVectorImgRes: Int? = null,
    preIconColor: Color? = null,
    @DrawableRes postVectorImgRes: Int? = null,
    postIconColor: Color? = null,
    text: String,
    onClick: (() -> Unit)?
) {
    BaseButton(
        modifier = modifier,
        size = size,
        type = type,
        preVectorImgRes = preVectorImgRes,
        preIconColor = preIconColor,
        postVectorImgRes = postVectorImgRes,
        postIconColor = postIconColor,
        text = text,
        onClick = onClick
    )
}

@Composable
fun SolidIconButton(
    modifier: Modifier = Modifier,
    size: ButtonSize = ButtonSize.L,
    type: ButtonTypes.Solid = ButtonTypes.Solid(),
    @DrawableRes vectorImgRes: Int,
    preIconColor: Color? = null,
    onClick: (() -> Unit)?
) {
    BaseIconButton(
        modifier = modifier,
        size = size,
        type = type,
        vectorImgRes = vectorImgRes,
        iconColor = preIconColor,
        onClick = onClick
    )
}

@Composable
fun SolidImageButton(
    modifier: Modifier = Modifier,
    size: ButtonSize = ButtonSize.L,
    type: ButtonTypes.Solid = ButtonTypes.Solid(),
    @DrawableRes imgRes: Int,
    onClick: (() -> Unit)?
) {
    BaseImageButton(
        modifier = modifier,
        size = size,
        type = type,
        imgRes = imgRes,
        onClick = onClick
    )
}