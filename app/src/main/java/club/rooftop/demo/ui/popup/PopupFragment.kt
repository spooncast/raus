package club.rooftop.demo.ui.popup

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import club.rooftop.demo.ui.BaseFragment
import club.rooftop.raus.components.button.SolidButton

class PopupFragment : BaseFragment() {

    override val actionBarTitle: String = "Popup"

    @Composable
    override fun Body() {
        Column {

            SolidButton(text = "Large Button") {

            }

            SolidButton(text = "Medium Button") {

            }

            SolidButton(text = "Small Button") {

            }
        }
    }
}