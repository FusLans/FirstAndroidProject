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
    var value by mutableStateOf("")
        private set

    fun onNewList() {
        list.add(value)
        value = ""
    }

    fun changeValue(newValue: String) {
        value = newValue
    }

}