package club.rooftop.raus.components.dialog

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
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
import club.rooftop.raus.components.button.ButtonTypes
import club.rooftop.raus.components.button.SolidButton
import club.rooftop.raus.foundation.color.Gray90
import club.rooftop.raus.foundation.color.Purple50
import club.rooftop.raus.foundation.typography.Body1RegularCenter
import club.rooftop.raus.foundation.typography.SubheadBoldCenter
import club.rooftop.raus.foundation.typography.TitleBoldCenter


@Composable
fun PopupDialog(
    title: String? = null,
    body: @Composable () -> Unit,
    primaryButtonText: String,
    primaryButtonType: ButtonTypes = ButtonTypes.Text,
    primaryButtonTextColor: Color = Gray90,
    secondaryButtonText: String? = null,
    onClickPrimaryButton: () -> Unit,
    onClickSecondaryButton: (() -> Unit)? = null,
    onDismiss: (() -> Unit) = {},
) {
    Dialog(onDismissRequest = {
        onDismiss()
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
    primaryButtonType: ButtonTypes,
    primaryButtonText: String,
    primaryButtonTextColor: Color,
    onClickPrimaryButton: () -> Unit,
    secondaryButtonText: String?,
    onClickSecondaryButton: (() -> Unit)?,
) {
    val modifier = Modifier
        .fillMaxWidth()
        .padding(
            top = if (primaryButtonType is ButtonTypes.Solid) 6.dp else 0.dp,
            bottom = if (primaryButtonType is ButtonTypes.Solid) 24.dp else 18.dp
        )

    if (primaryButtonType is ButtonTypes.Solid) {
        VerticalButtons(
            modifier,
            primaryButtonType,
            primaryButtonText,
            primaryButtonTextColor,
            onClickPrimaryButton,
            secondaryButtonText,
            onClickSecondaryButton
        )
    } else {
        HorizontalButtons(
            modifier,
            secondaryButtonText,
            onClickSecondaryButton,
            primaryButtonType,
            primaryButtonText,
            primaryButtonTextColor,
            onClickPrimaryButton
        )
    }
}

@Composable
private fun HorizontalButtons(
    modifier: Modifier,
    secondaryButtonText: String?,
    onClickSecondaryButton: (() -> Unit)?,
    primaryButtonType: ButtonTypes,
    primaryButtonText: String,
    primaryButtonTextColor: Color,
    onClickPrimaryButton: () -> Unit,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (secondaryButtonText != null) {
            SecondaryButton(secondaryButtonText, onClickSecondaryButton)
            HorizontalSpacer(size = 40.dp)
        }

        PrimaryButton(
            primaryButtonType,
            primaryButtonText,
            primaryButtonTextColor,
            onClickPrimaryButton
        )
    }
}

@Composable
private fun VerticalButtons(
    modifier: Modifier,
    primaryButtonType: ButtonTypes,
    primaryButtonText: String,
    primaryButtonTextColor: Color,
    onClickPrimaryButton: () -> Unit,
    secondaryButtonText: String?,
    onClickSecondaryButton: (() -> Unit)?,
) {
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
            VerticalSpacer(size = 8.dp)
            SecondaryButton(secondaryButtonText, onClickSecondaryButton)
        }
    }
}

@Composable
private fun PrimaryButton(
    buttonType: ButtonTypes,
    text: String,
    textColor: Color,
    onClick: () -> Unit,
) {
    when (buttonType) {
        is ButtonTypes.Solid -> SolidButton(
            modifier = Modifier.widthIn(min = 200.dp),
            type = buttonType,
            text = text,
            onClick = onClick
        )
        else -> Box(
            modifier = Modifier.height(40.dp).clickable { onClick() },
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.Center)
                    .widthIn(min = 100.dp),
                text = text,
                color = textColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = SubheadBoldCenter
            )
        }
    }
}

@Composable
private fun SecondaryButton(
    buttonText: String,
    onClick: (() -> Unit)?,
) {
    Box(
        modifier = Modifier.height(40.dp).clickable { onClick?.invoke() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = buttonText,
            modifier = Modifier
                .align(Alignment.Center)
                .widthIn(min = 100.dp),
            color = Gray90,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = SubheadBoldCenter,
        )
    }
}

@Composable
private fun TitleArea(title: String?) {
    if (title != null) {
        Text(
            text = title,
            modifier = Modifier.fillMaxWidth(),
            color = Gray90,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = TitleBoldCenter
        )

        VerticalSpacer(size = 16.dp)
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewHorizontalOneButton() {
    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            contentAlignment = Alignment.Center,
        ) {
            PopupDialog(
                title = "Title",
                body = {
                    Text(
                        text = "This Twitch account is already connected to an another rooftop account. Please try an another Twitch account.",
                        style = Body1RegularCenter)
                },
                primaryButtonText = "Confirm",
                primaryButtonType = ButtonTypes.Text,
                primaryButtonTextColor = Gray90,
                secondaryButtonText = null,
                onClickPrimaryButton = {

                },
                onClickSecondaryButton = null,
            )
        }
    }
}

/**
 * Horizontal
 * Two Button
 */
@Preview(showBackground = true)
@Composable
fun PreviewHorizontalTwoButton() {
    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            contentAlignment = Alignment.Center,
        ) {
            PopupDialog(
                title = "Title",
                body = {
                    Text(
                        text = "This Twitch account is already connected to an another rooftop account. Please try an another Twitch account.",
                        style = Body1RegularCenter
                    )
                },
                primaryButtonText = "OK",
                primaryButtonType = ButtonTypes.Text,
                primaryButtonTextColor = Purple50,
                secondaryButtonText = "Cancel",
                onClickPrimaryButton = {

                },
                onClickSecondaryButton = null,
            )
        }
    }
}

/**
 * Vertical
 * One Button
 */
@Preview(showBackground = true)
@Composable
fun PreviewVerticalOneButton() {
    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            contentAlignment = Alignment.Center,
        ) {
            PopupDialog(
                title = "Title",
                body = {
                    Text(
                        text = "This Twitch account is already connected to an another rooftop account. Please try an another Twitch account.",
                        style = Body1RegularCenter
                    )
                },
                primaryButtonText = "Confirm",
                primaryButtonType = ButtonTypes.Solid(),
                primaryButtonTextColor = Gray90,
                secondaryButtonText = null,
                onClickPrimaryButton = {

                },
                onClickSecondaryButton = null,
            )
        }
    }
}

/**
 * Vertical
 * Two Button
 */
@Preview(showBackground = true)
@Composable
fun PreviewVerticalTwoButton() {
    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            contentAlignment = Alignment.Center,
        ) {
            PopupDialog(
                title = "Title",
                body = {
                    Text(
                        text = "This Twitch account is already connected to an another rooftop account. Please try an another Twitch account.",
                        style = Body1RegularCenter
                    )
                },
                primaryButtonText = "Confirm",
                primaryButtonType = ButtonTypes.Solid(),
                primaryButtonTextColor = Gray90,
                secondaryButtonText = "Cancel",
                onClickPrimaryButton = {

                },
                onClickSecondaryButton = null,
            )
        }
    }
}
