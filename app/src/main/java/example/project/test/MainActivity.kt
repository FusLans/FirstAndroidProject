package example.project.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val mainViewModel by viewModels<MainViewModel>()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Gray)
                    .statusBarsPadding(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = mainViewModel.newValue,
                    onValueChange = { inputValue: String ->
                        mainViewModel.newValue = inputValue

                    },

                )
                Button(onClick = {
                    mainViewModel.onNewList(
                        mainViewModel.newValue
                    )

                },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Green,
                        contentColor = Color.Black
                    )
                ) {
                    Text(
                        text = "Нажми меня"
                    )
                }

                //list.add()
                mainViewModel.list.forEach {
                    Text(
                        text = it.toString(),
                        modifier = Modifier
                            .padding(20.dp)
                            .clickable { mainViewModel.list.remove(it) },
                        fontSize = 20.sp

                    )
                }

            }

        }

    }
}





