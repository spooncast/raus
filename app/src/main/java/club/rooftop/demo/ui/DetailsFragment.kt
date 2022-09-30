package club.rooftop.demo.ui

import androidx.compose.runtime.Composable
import androidx.navigation.fragment.navArgs
import club.rooftop.demo.ui.badge.BadgeScreen
import club.rooftop.demo.ui.buttons.ButtonScreen
import club.rooftop.demo.ui.image.ImageScreen
import club.rooftop.demo.ui.popup.PopupScreen
import club.rooftop.demo.ui.tags.TagScreen

class DetailsFragment : BaseFragment() {

    private val args: DetailsFragmentArgs by navArgs()

    override val actionBarTitle: String
        get() = args.uiComponent.name

    @Composable
    override fun Body() {
        when(args.uiComponent) {
            UiComponent.BUTTON -> ButtonScreen()
            UiComponent.TAG -> TagScreen()
            UiComponent.POPUP -> PopupScreen()
            UiComponent.IMAGE -> ImageScreen()
            UiComponent.BADGE -> BadgeScreen()
        }
    }
}