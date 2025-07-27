package example.project.test

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var textNow by mutableStateOf("")
        private set

    fun onNewText(newTextNow: String) {
        textNow = newTextNow
    }

}