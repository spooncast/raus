package club.rooftop.demo.ui.buttons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import club.rooftop.demo.R
import club.rooftop.raus.common.VerticalSpacer
import club.rooftop.raus.components.button.ButtonSize
import club.rooftop.raus.components.button.ButtonTypes
import club.rooftop.raus.components.button.OutlinedButton
import club.rooftop.raus.components.button.SolidButton

@Composable
fun ButtonScreen() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        SolidButtons()

        VerticalSpacer(size = 32.dp)

        OutlinedButtons()
    }
}

@Composable
private fun OutlinedButtons() {
    Text(text = "Outlined Buttons")

    VerticalSpacer(size = 8.dp)

    OutlinedButton(
        size = ButtonSize.L,
        type = ButtonTypes.Outlined(),
        text = "Large Button"
    ) {}

    VerticalSpacer(size = 8.dp)

    OutlinedButton(
        size = ButtonSize.M,
        type = ButtonTypes.Outlined(),
        text = "Medium Button"
    ) {}

    VerticalSpacer(size = 8.dp)

    OutlinedButton(
        size = ButtonSize.S,
        type = ButtonTypes.Outlined(),
        text = "Small Button"
    ) {}

    VerticalSpacer(size = 8.dp)

    OutlinedButton(
        preVectorImgRes = R.drawable.ic_group,
        type = ButtonTypes.Outlined(),
        text = "Button with Icon"
    ) {}

    VerticalSpacer(size = 8.dp)

    OutlinedButton(
        size = ButtonSize.S,
        preVectorImgRes = R.drawable.ic_eye,
        type = ButtonTypes.Outlined(Color.White),
        text = "27",
    ) {}
}

@Composable
private fun SolidButtons() {
    Text(text = "Solid Buttons")

    VerticalSpacer(size = 8.dp)

    SolidButton(
        size = ButtonSize.L,
        text = "Large Button"
    ) {}

    VerticalSpacer(size = 8.dp)

    SolidButton(
        size = ButtonSize.M,
        text = "Medium Button"
    ) {}

    VerticalSpacer(size = 8.dp)

    SolidButton(
        size = ButtonSize.S,
        text = "Small Button"
    ) {}

    VerticalSpacer(size = 8.dp)

    SolidButton(
        preVectorImgRes = R.drawable.ic_group,
        text = "Button with Icon"
    ) {}
}