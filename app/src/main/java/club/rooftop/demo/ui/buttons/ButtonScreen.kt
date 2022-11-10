package club.rooftop.demo.ui.buttons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import club.rooftop.demo.R
import club.rooftop.raus.common.HorizontalSpacer
import club.rooftop.raus.common.VerticalSpacer
import club.rooftop.raus.components.button.ButtonSize
import club.rooftop.raus.components.button.ButtonTypes
import club.rooftop.raus.components.button.OutlinedButton
import club.rooftop.raus.components.button.OutlinedIconButton
import club.rooftop.raus.components.button.SolidButton
import club.rooftop.raus.components.button.SolidIconButton

@Composable
fun ButtonScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {

        SolidButtons()

        VerticalSpacer(size = 32.dp)

        OutlinedButtons()
    }
}

@Composable
private fun OutlinedButtons() {
    Text(text = "Outlined Buttons")

    listOf(
        ButtonSize.L,
        ButtonSize.M,
        ButtonSize.S,
        ButtonSize.XS
    ).forEach { btnSize ->
        VerticalSpacer(size = 8.dp)

        OutlinedButton(
            size = btnSize,
            type = ButtonTypes.Outlined(),
            text = "Button ${btnSize.name}"
        ) {}
    }

    VerticalSpacer(size = 8.dp)

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Bottom
    ) {
        listOf(
            ButtonSize.ICON_L,
            ButtonSize.ICON_M,
            ButtonSize.ICON_S,
            ButtonSize.ICON_XS
        ).forEach { btnSize ->
            HorizontalSpacer(size = 8.dp)

            OutlinedIconButton(
                size = btnSize,
                type = ButtonTypes.Outlined(),
                vectorImgRes = R.drawable.ic_eye
            ) {}
        }
    }

    VerticalSpacer(size = 8.dp)

    OutlinedButton(
        preVectorImgRes = R.drawable.ic_eye,
        type = ButtonTypes.Outlined(Color.White),
        text = "27",
    ) {}

    VerticalSpacer(size = 8.dp)

    OutlinedButton(
        postVectorImgRes = R.drawable.ic_eye,
        type = ButtonTypes.Outlined(Color.White),
        text = "27",
    ) {}

    VerticalSpacer(size = 8.dp)

    OutlinedButton(
        preVectorImgRes = R.drawable.ic_eye,
        postVectorImgRes = R.drawable.ic_eye,
        type = ButtonTypes.Outlined(Color.White),
        text = "27",
    ) {}
}

@Composable
private fun SolidButtons() {
    Text(text = "Solid Buttons")

    listOf(
        ButtonSize.L,
        ButtonSize.M,
        ButtonSize.S,
        ButtonSize.XS
    ).forEach { btnSize ->
        VerticalSpacer(size = 8.dp)

        SolidButton(
            size = btnSize,
            text = "Button ${btnSize.name}"
        ) {}
    }

    VerticalSpacer(size = 8.dp)

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Bottom
    ) {
        listOf(
            ButtonSize.ICON_L,
            ButtonSize.ICON_M,
            ButtonSize.ICON_S,
            ButtonSize.ICON_XS
        ).forEach { btnSize ->
            HorizontalSpacer(size = 8.dp)

            SolidIconButton(
                size = btnSize,
                type = ButtonTypes.Solid(),
                vectorImgRes = R.drawable.ic_eye
            ) {}
        }
    }

    VerticalSpacer(size = 8.dp)

    SolidButton(
        preVectorImgRes = R.drawable.ic_group,
        text = "Prefix Button"
    ) {}

    VerticalSpacer(size = 8.dp)

    SolidButton(
        text = "Postfix Button",
        postVectorImgRes = R.drawable.ic_group,
        onClick = null
    )

    VerticalSpacer(size = 8.dp)

    SolidButton(
        preVectorImgRes = R.drawable.ic_group,
        text = "Both Button",
        postVectorImgRes = R.drawable.ic_group,
        onClick = null
    )
}