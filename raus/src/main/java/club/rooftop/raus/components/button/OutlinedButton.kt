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

@Composable
fun OutlinedButton(
    modifier: Modifier = Modifier,
    size: ButtonSize = ButtonSize.L,
    type: ButtonTypes.Outlined = ButtonTypes.Outlined(),
    @DrawableRes preVectorImgRes: Int? = null,
    @DrawableRes postVectorImgRes: Int? = null,
    text: String,
    onClick: () -> Unit
) {
    BaseButton(
        modifier = modifier,
        size = size,
        type = type,
        preVectorImgRes = preVectorImgRes,
        postVectorImgRes = postVectorImgRes,
        text = text,
        onClick = onClick
    )
}
