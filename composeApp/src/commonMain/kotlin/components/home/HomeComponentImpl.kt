package components.home

import com.arkivanov.decompose.ComponentContext
import components.BaseComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeComponentImpl(
    componentContext: ComponentContext
) : BaseComponent<Unit>(componentContext, Unit), HomeComponent {

    fun getData() {
        scope.launch(Dispatchers.Main) {  }
    }
}