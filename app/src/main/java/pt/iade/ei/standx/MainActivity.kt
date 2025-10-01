package pt.iade.ei.standx

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.ei.standx.ui.components.CarListItem
import pt.iade.ei.standx.ui.theme.StandXTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StandXTheme {
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    StandXTheme {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Text("StandX")

            for (i in 1..8) {
                CarListItem(
                    make = "Mini",
                    model = "Cooper",
                    year = 1989 + (i * 3),
                    km = 420000 * (10 / i),
                    price = 100000f * i,
                    transmission = "Auto",
                    fuel = "GPL",
                    seats = 12 - i,
                    imageId = R.drawable.mini_bean
                )
            }
        }
    }
}
