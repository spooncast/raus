package club.rooftop.demo.ui.popup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import club.rooftop.raus.common.VerticalSpacer
import club.rooftop.raus.components.button.ButtonType
import club.rooftop.raus.components.button.SolidButton
import club.rooftop.raus.components.dialog.PopupDialog
import club.rooftop.raus.foundation.color.Purple50
import club.rooftop.raus.foundation.typography.SubheadRegularCenter

@Composable
fun PopupScreen() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        SolidButton(text = "1 button popup") {
            popupType.value = PopupType.HORIZONTAL_1_BUTTON
        }

        VerticalSpacer(size = 8.dp)

        SolidButton(text = "2 button popup") {
            popupType.value = PopupType.HORIZONTAL_2_BUTTON
        }

        VerticalSpacer(size = 8.dp)

        SolidButton(text = "Vertical 1 button popup") {
            popupType.value = PopupType.VERTICAL_1_BUTTON
        }

        VerticalSpacer(size = 8.dp)

        SolidButton(text = "Vertical 2 button popup") {
            popupType.value = PopupType.VERTICAL_2_BUTTON
        }

        VerticalSpacer(size = 8.dp)

        SolidButton(text = "2 button popup - very long title") {
            popupType.value = PopupType.HORIZONTAL_2_BUTTON_LONG_TITLE
        }


        PopupDialogs()
    }
}

private var popupType = mutableStateOf<PopupType?>(null)

@Composable
private fun PopupDialogs() {
    when (popupType.value) {
        PopupType.HORIZONTAL_1_BUTTON -> {
            PopupDialog(
                title = "Title",
                body = {
                    BodyText()
                },
                primaryButtonText = "Confirm",
                onClickPrimaryButton = { /*TODO*/ },
                onDismiss = { popupType.value = null }
            )
        }
        PopupType.HORIZONTAL_2_BUTTON -> {
            PopupDialog(
                title = "Title",
                body = {
                    BodyText()
                },
                primaryButtonText = "Ok",
                primaryButtonTextColor = Purple50,
                secondaryButtonText = "Cancel",
                onClickPrimaryButton = { /*TODO*/ },
                onDismiss = { popupType.value = null }
            )
        }
        PopupType.HORIZONTAL_2_BUTTON_LONG_TITLE -> {
            PopupDialog(
                title = "Anakin Skywalker was a human Jedi Knight, one of the central antagonist of the original trilogy.",
                body = {
                    BodyText()
                },
                primaryButtonText = "Ok",
                primaryButtonTextColor = Purple50,
                secondaryButtonText = "Cancel",
                onClickPrimaryButton = { /*TODO*/ },
                onDismiss = { popupType.value = null }
            )
        }
        PopupType.VERTICAL_1_BUTTON -> {
            PopupDialog(
                title = "Title",
                body = {
                    BodyText()
                },
                primaryButtonText = "Button",
                primaryButtonType = ButtonType.Solid,
                onClickPrimaryButton = { /*TODO*/ },
                onDismiss = { popupType.value = null }
            )
        }
        PopupType.VERTICAL_2_BUTTON -> {
            PopupDialog(
                title = "Title",
                body = {
                    BodyText()
                },
                primaryButtonText = "Button",
                primaryButtonType = ButtonType.Solid,
                secondaryButtonText = "Cancel",
                onClickPrimaryButton = { /*TODO*/ },
                onDismiss = { popupType.value = null }
            )
        }
        else -> {}
    }
}

@Composable
private fun BodyText() {
    Text(
        text = "Anakin Skywalker was a human Jedi Knight, one of the central antagonist of the original trilogy.",
        style = SubheadRegularCenter
    )
}

private enum class PopupType {
    HORIZONTAL_1_BUTTON,
    HORIZONTAL_2_BUTTON,
    HORIZONTAL_2_BUTTON_LONG_TITLE,
    VERTICAL_1_BUTTON,
    VERTICAL_2_BUTTON
}