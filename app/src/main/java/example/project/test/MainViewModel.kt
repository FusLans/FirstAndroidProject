package example.project.test

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var list = mutableStateListOf("")
        private set
    var newValue by mutableStateOf("")
    fun onNewList(newListNow: String) {

        list.add(newListNow)
    }

}