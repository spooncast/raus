package club.rooftop.raus.components.dialog

import club.rooftop.raus.style.typography.Body1RegularCenter
import club.rooftop.raus.style.typography.SubheadBoldCenter
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import club.rooftop.raus.common.HorizontalSpacer
import club.rooftop.raus.common.VerticalSpacer
import club.rooftop.raus.components.button.ButtonType
import club.rooftop.raus.components.button.SolidButton
import club.rooftop.raus.foundation.color.Gray90
import club.rooftop.raus.foundation.color.Purple50


/**
 * https://www.figma.com/file/BIDgQ7Eq9LV09c5vDxXxhw/Rooftop-Design-Library?node-id=1478%3A296
 */
@Composable
fun PopupDialog(
    title: String? = null,
    body: @Composable () -> Unit,
    primaryButtonText: String,
    primaryButtonType: ButtonType = ButtonType.Text,
    primaryButtonTextColor: Color = Gray90,
    secondaryButtonText: String? = null,
    onClickPrimaryButton: () -> Unit,
    onClickSecondaryButton: (() -> Unit)? = null,
    onDismiss: (() -> Unit)? = null,
) {
    Dialog(onDismissRequest = {

    }) {
        Surface(
            modifier = Modifier.clip(RoundedCornerShape(16.dp))
        ) {
            Column(
                Modifier.padding(top = 30.dp, start = 30.dp, end = 30.dp)
            ) {
                TitleArea(title)

                body()

                VerticalSpacer(size = 18.dp)

                FooterArea(
                    primaryButtonType,
                    primaryButtonText,
                    primaryButtonTextColor,
                    onClickPrimaryButton,
                    secondaryButtonText,
                    onClickSecondaryButton
                )
            }
        }
    }
}

@Composable
private fun FooterArea(
    primaryButtonType: ButtonType,
    primaryButtonText: String,
    primaryButtonTextColor: Color,
    onClickPrimaryButton: () -> Unit,
    secondaryButtonText: String?,
    onClickSecondaryButton: (() -> Unit)?,
) {
    val paddingTop = if (primaryButtonType == ButtonType.Solid) 6.dp else 0.dp
    val paddingBottom = if (primaryButtonType == ButtonType.Solid) 24.dp else 18.dp
    val modifier = Modifier.fillMaxWidth().padding(top = paddingTop, bottom = paddingBottom)

    if (primaryButtonType == ButtonType.Solid) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PrimaryButton(
                primaryButtonType,
                primaryButtonText,
                primaryButtonTextColor,
                onClickPrimaryButton
            )

            if (secondaryButtonText != null) {
                VerticalSpacer(size = 20.dp)
                SecondaryButton(secondaryButtonText, onClickSecondaryButton)
            }
        }
    } else {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (secondaryButtonText != null) {
                SecondaryButton(secondaryButtonText, onClickSecondaryButton)
                HorizontalSpacer(size = 60.dp)
            }

            PrimaryButton(
                primaryButtonType,
                primaryButtonText,
                primaryButtonTextColor,
                onClickPrimaryButton
            )
        }
    }
}

@Composable
private fun PrimaryButton(
    buttonType: ButtonType,
    text: String,
    textColor: Color,
    onClick: () -> Unit,
) {
    when (buttonType) {
        ButtonType.Solid -> SolidButton(
            modifier = Modifier.widthIn(min = 200.dp),
            text = text,
            onClick = onClick
        )
        else -> Text(
            modifier = Modifier.widthIn(min = 80.dp),
            text = text,
            color = textColor,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = SubheadBoldCenter
        )
    }
}

@Composable
private fun SecondaryButton(
    buttonText: String,
    onClick: (() -> Unit)?,
) {
    Text(
        text = buttonText,
        color = Gray90,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        style = SubheadBoldCenter,
        modifier = Modifier.widthIn(min = 80.dp).clickable { onClick?.invoke() }
    )
}

@Composable
private fun TitleArea(title: String?) {
    if (title != null) {
        Text(
            text = title,
            modifier = Modifier.fillMaxWidth(),
            color = Gray90,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = SubheadBoldCenter
        )

        VerticalSpacer(size = 16.dp)
    }
}

/**
 * Horizontal
 * One Button
 *
 * https://www.figma.com/file/BIDgQ7Eq9LV09c5vDxXxhw/Rooftop-Design-Library?node-id=1478%3A553
 */
@Preview(showBackground = true)
@Composable
fun PreviewHorizontalOneButton() {
    PopupDialog(
        title = "Title",
        body = {
            Text(
                text = "This Twitch account is already connected to an another rooftop account. Please try an another Twitch account.",
                style = Body1RegularCenter)
        },
        primaryButtonText = "Confirm",
        primaryButtonType = ButtonType.Text,
        primaryButtonTextColor = Gray90,
        secondaryButtonText = null,
        onClickPrimaryButton = {

        },
        onClickSecondaryButton = null,
        onDismiss = null
    )
}

/**
 * Horizontal
 * Two Button
 *
 * https://www.figma.com/file/BIDgQ7Eq9LV09c5vDxXxhw/Rooftop-Design-Library?node-id=1478%3A553
 */
@Preview(showBackground = true)
@Composable
fun PreviewHorizontalTwoButton() {
    PopupDialog(
        title = "Title",
        body = {
            Text(
                text = "This Twitch account is already connected to an another rooftop account. Please try an another Twitch account.",
                style = Body1RegularCenter
            )
        },
        primaryButtonText = "OK",
        primaryButtonType = ButtonType.Text,
        primaryButtonTextColor = Purple50,
        secondaryButtonText = "Cancel",
        onClickPrimaryButton = {

        },
        onClickSecondaryButton = null,
        onDismiss = null
    )
}

/**
 * Vertical
 * One Button
 *
 * https://www.figma.com/file/BIDgQ7Eq9LV09c5vDxXxhw/Rooftop-Design-Library?node-id=1478%3A553
 */
@Preview(showBackground = true)
@Composable
fun PreviewVerticalOneButton() {
    PopupDialog(
        title = "Title",
        body = {
            Text(
                text = "This Twitch account is already connected to an another rooftop account. Please try an another Twitch account.",
                style = Body1RegularCenter
            )
        },
        primaryButtonText = "Confirm",
        primaryButtonType = ButtonType.Solid,
        primaryButtonTextColor = Gray90,
        secondaryButtonText = null,
        onClickPrimaryButton = {

        },
        onClickSecondaryButton = null,
        onDismiss = null
    )
}

/**
 * Vertical
 * Two Button
 *
 * https://www.figma.com/file/BIDgQ7Eq9LV09c5vDxXxhw/Rooftop-Design-Library?node-id=1478%3A553
 */
@Preview(showBackground = true)
@Composable
fun PreviewVerticalTwoButton() {
    PopupDialog(
        title = "Title",
        body = {
            Text(
                text = "This Twitch account is already connected to an another rooftop account. Please try an another Twitch account.",
                style = Body1RegularCenter
            )
        },
        primaryButtonText = "Confirm",
        primaryButtonType = ButtonType.Solid,
        primaryButtonTextColor = Gray90,
        secondaryButtonText = "Cancel",
        onClickPrimaryButton = {

        },
        onClickSecondaryButton = null,
        onDismiss = null
    )
}
