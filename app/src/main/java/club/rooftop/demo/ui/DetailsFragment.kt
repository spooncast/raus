package club.rooftop.demo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.fragment.navArgs
import club.rooftop.demo.ui.buttons.ButtonScreen
import club.rooftop.demo.ui.popup.PopupScreen
import club.rooftop.demo.ui.tags.TagScreen
import club.rooftop.raus.foundation.color.ColorPalette

class DetailsFragment : Fragment() {

    private val args: DetailsFragmentArgs by navArgs()

    private val actionBarTitle: String
        get() = args.uiComponent.name

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Screen()
            }
        }
    }

    @Composable
    private fun Screen() {
        MaterialTheme(colors = ColorPalette) {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = {
                    Box(
                        modifier = Modifier
                            .background(color = MaterialTheme.colors.primary)
                            .fillMaxWidth()
                            .height(52.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(start = 16.dp),
                            text = actionBarTitle,
                            color = MaterialTheme.colors.onPrimary,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                    }
                }
            ) {
                when(args.uiComponent) {
                    UiComponent.Button -> ButtonScreen()
                    UiComponent.Tag -> TagScreen()
                    UiComponent.Popup -> PopupScreen()
                }
            }
        }
    }
}