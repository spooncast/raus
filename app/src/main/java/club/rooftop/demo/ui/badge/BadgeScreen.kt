package club.rooftop.demo.ui.badge

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import club.rooftop.demo.R
import club.rooftop.raus.common.VerticalSpacer
import club.rooftop.raus.components.badge.Badge
import club.rooftop.raus.components.badge.DotBadge
import club.rooftop.raus.components.button.ButtonSize
import club.rooftop.raus.components.button.ButtonTypes
import club.rooftop.raus.components.button.OutlinedButton
import club.rooftop.raus.components.button.SolidButton

@Composable
fun BadgeScreen() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Badge(text = "10")

        VerticalSpacer(size = 32.dp)

        DotBadge()
    }
}