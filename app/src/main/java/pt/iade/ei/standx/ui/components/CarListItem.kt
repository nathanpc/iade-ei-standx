package pt.iade.ei.standx.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.ei.standx.R
import pt.iade.ei.standx.models.CarItem
import pt.iade.ei.standx.ui.theme.StandXTheme

@Composable
fun CarListItem(
    make: String,
    model: String,
    year: Int,
    km: Int,
    price: Float,
    transmission: String,
    fuel: String,
    seats: Int,
    @DrawableRes imageId: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 10.dp,
                vertical = 5.dp
            )
    ) {
        val title = "$make $model $year"

        Image(
            painter = painterResource(imageId),
            contentDescription = title,
            modifier = Modifier
                .padding(end = 15.dp)
                .height(72.dp)
        )

        Column {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            Text("${km}km - £ $price")

            Text(
                text = "$transmission | $fuel | $seats px",
                color = Color.Gray
            )
        }
    }
}

@Composable
fun CarListItem(
    item: CarItem
) {
    CarListItem(
        make = item.make,
        model = item.model,
        year = item.year,
        km = item.km,
        price = item.price,
        transmission = item.transmission,
        fuel = item.fuel,
        seats = item.seats,
        imageId = R.drawable.mini_bean
    )
}

@Preview(showBackground = true)
@Composable
fun ListItemPreview() {
    val item = CarItem(
        id = 123,
        make = "Mini",
        model = "Cooper",
        year = 1989,
        km = 420000,
        price = 100000f,
        transmission = "Auto",
        fuel = "GPL",
        seats = 12
    )

    StandXTheme {
        CarListItem(item)
    }
}
