package example.project.test

import android.icu.text.SimpleDateFormat
import android.icu.util.TimeZone
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import java.util.Date
import java.util.Locale

class MainActivity : ComponentActivity() {

    val mainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            Scaffold(
                content = { Innerpadding: PaddingValues ->
                    Column(
                        modifier = Modifier
                            .padding(Innerpadding)
                            .fillMaxWidth()
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {

                    TextField(
                        value = mainViewModel.textNow,
                        modifier = Modifier.padding(Innerpadding),
                        onValueChange = { inputText: String ->
                            mainViewModel.onNewText(inputText)

                        }

                    )
                   // Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_launcher_background),
                        contentDescription = null,
                        modifier = Modifier.size(size = 40.dp).clickable { }



                    )
//                        DateTime()
//                        Counter()
                    }

                }
            )


        }

    }
}

@Composable
fun DateTime() {
    val df = SimpleDateFormat("dd:MM.yyyy HH:mm", Locale.getDefault()).apply {

        timeZone = TimeZone.getTimeZone("GMT+03")
    }
    val formattedDate = df.format(Date())
    Text(
        text = formattedDate,
    )
}

@Composable
fun Counter() {
    var count by remember { mutableStateOf(0) }
    Text(
        text = count.toString(),

        )
    Row {
        Button(
            onClick = {
                count++

            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Green,
                contentColor = Color.Black
            )
        )
        {
            Text(
                text = "+"
            )

        }
        Button(
            onClick = {
                count--
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.Black
            )
        )
        {
            Text(
                text = "-"
            )
        }

    }

}





