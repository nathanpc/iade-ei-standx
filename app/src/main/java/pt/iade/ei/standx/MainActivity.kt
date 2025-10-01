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

@Composable
fun CarListItem() {
    Column {
        Text("Mini Cooper 1989")
        Text("1989 - 420.000km - £ 100.000")
    }
}

@Preview(showBackground = true)
@Composable
fun ListItemPreview() {
    StandXTheme {
        CarListItem()
    }
}
