package app.ute.scaffold.ui.component


import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(title: String, actions: @Composable () -> Unit = {}) {
    TopAppBar(
        title = { Text(title) },
        actions = { actions() }
    )
}