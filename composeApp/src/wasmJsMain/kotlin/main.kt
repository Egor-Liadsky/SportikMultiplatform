import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.CanvasBasedWindow
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import components.root.RootComponentImpl
import ui.root.RootScreen
import utils.attachToDocument

@OptIn(ExperimentalComposeUiApi::class)
fun main() {

    val lifecycle = LifecycleRegistry()

    val root = RootComponentImpl(
        componentContext = DefaultComponentContext(lifecycle = lifecycle)
    )

    lifecycle.attachToDocument()

    CanvasBasedWindow(canvasElementId = "ComposeTarget") {
        RootScreen(component = root, modifier = Modifier.fillMaxSize())
    }
}