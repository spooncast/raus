package club.rooftop.demo.ui

import android.os.Bundle
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
import androidx.fragment.app.Fragment
import club.rooftop.raus.foundation.color.ColorPalette

abstract class BaseFragment : Fragment() {

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

    protected abstract val actionBarTitle: String

    @Composable
    protected abstract fun Body()

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
                Body()
            }
        }
    }
}