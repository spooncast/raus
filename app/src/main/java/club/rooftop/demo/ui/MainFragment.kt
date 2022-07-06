package club.rooftop.demo.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.fragment.findNavController
import club.rooftop.raus.foundation.color.Gray10

class MainFragment : BaseFragment() {

    override val actionBarTitle: String = "RAUS"

    @Composable
    override fun Body() {
        Column {
            ListItem("Button") {
                navigate(NavigateTo.Button)
            }

            ListItem("Popup") {
                navigate(NavigateTo.Popup)
            }
        }
    }

    @Composable
    private fun ListItem(
        title: String,
        onClick: () -> Unit
    ) {
        Text(
            text = title,
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = onClick)
                .border(1.dp, Gray10)
                .padding(16.dp)
        )
    }

    private fun navigate(nav: NavigateTo) {
        when(nav) {
            NavigateTo.Button -> MainFragmentDirections.actionMainFragmentToButtonsFragment()
            NavigateTo.Popup -> MainFragmentDirections.actionMainFragmentToPopupFragment()
        }.let {
            findNavController().navigate(it)
        }
    }
}

enum class NavigateTo {
    Button, Popup
}