package pt.iade.ei.standx

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.httpGet
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import kotlinx.coroutines.runBlocking
import pt.iade.ei.standx.controllers.CarItemController
import pt.iade.ei.standx.models.CarItem
import pt.iade.ei.standx.ui.components.CarListItem
import pt.iade.ei.standx.ui.theme.StandXTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // List<CarItem> carsList = new List<CarItem>();
            // val carsList = mutableListOf<CarItem>()
            val carsList = remember { mutableStateListOf<CarItem>() }

            StandXTheme {
                CarItemController().GetListOfCars { list ->
                    for (car in list) {
                        carsList.add(car)
                    }
                }

                MainView(carsList)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(
    carsList: List<CarItem>
) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("StandX")
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "This will be a pretty bottom bar.",
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            for (car in carsList) {
                CarListItem(car)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    // Created a fake list.
    val carsList = mutableListOf<CarItem>(
        CarItem(
            id = 123,
            make = "Mini",
            model = "Cooper",
            year = 1989,
            km = 420000,
            price = 100000f,
            transmission = "Auto",
            fuel = "GPL",
            seats = 12)
    )
    for (i in 1..6) {
        carsList.add(CarItem(
            make = "Mini",
            model = "Cooper",
            year = 1989 + (i * 3),
            km = 420000 * (10 / i),
            price = 100000f * i,
            transmission = "Auto",
            fuel = "GPL",
            seats = 12 - i
        ))
    }

    StandXTheme {
        MainView(carsList)
    }
}
