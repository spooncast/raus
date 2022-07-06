package club.rooftop.demo.ui.buttons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import club.rooftop.demo.ui.BaseFragment
import club.rooftop.raus.common.VerticalSpacer
import club.rooftop.raus.components.button.ButtonSize
import club.rooftop.raus.components.button.SolidButton

class ButtonsFragment : BaseFragment() {

    override val actionBarTitle: String = "Button"

    @Composable
    override fun Body() {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            SolidButton(
                size = ButtonSize.L,
                text = "Large Button"
            ) {

            }

            VerticalSpacer(size = 8.dp)

            SolidButton(
                size = ButtonSize.M,
                text = "Medium Button"
            ) {

            }

            VerticalSpacer(size = 8.dp)

            SolidButton(
                size = ButtonSize.S,
                text = "Small Button"
            ) {

            }
        }
    }

}