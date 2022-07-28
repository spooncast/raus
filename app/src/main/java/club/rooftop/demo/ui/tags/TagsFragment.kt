package club.rooftop.demo.ui.tags

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import club.rooftop.demo.ui.BaseFragment
import club.rooftop.raus.common.VerticalSpacer
import club.rooftop.raus.components.button.ButtonSize
import club.rooftop.raus.components.button.SolidButton

class TagsFragment : BaseFragment() {

    override val actionBarTitle: String = "Tags"

    @Composable
    override fun Body() {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            SolidButton(
                size = ButtonSize.L,
                text = "Large Tag"
            ) {

            }

            VerticalSpacer(size = 8.dp)

            SolidButton(
                size = ButtonSize.M,
                text = "Medium Tag"
            ) {

            }

            VerticalSpacer(size = 8.dp)

            SolidButton(
                size = ButtonSize.S,
                text = "Small Tag"
            ) {

            }
        }
    }
}