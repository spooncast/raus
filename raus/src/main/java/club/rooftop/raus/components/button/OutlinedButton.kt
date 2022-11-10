package club.rooftop.raus.components.button

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun OutlinedButton(
    modifier: Modifier = Modifier,
    size: ButtonSize = ButtonSize.L,
    type: ButtonTypes.Outlined = ButtonTypes.Outlined(),
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
fun OutlinedIconButton(
    modifier: Modifier = Modifier,
    size: ButtonSize = ButtonSize.ICON_L,
    type: ButtonTypes.Outlined = ButtonTypes.Outlined(),
    @DrawableRes vectorImgRes: Int,
    iconColor: Color? = null,
    onClick: (() -> Unit)?
) {
    BaseIconButton(
        modifier = modifier,
        size = size,
        type = type,
        vectorImgRes = vectorImgRes,
        iconColor = iconColor,
        onClick = onClick
    )
}

@Composable
fun OutlinedImageButton(
    modifier: Modifier = Modifier,
    size: ButtonSize = ButtonSize.ICON_L,
    type: ButtonTypes.Outlined = ButtonTypes.Outlined(),
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
