package pt.iade.ei.standx.ui.components

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
import pt.iade.ei.standx.ui.theme.StandXTheme

@Composable
fun CarListItem() {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(R.drawable.mini_bean),
            contentDescription = "Mr. Bean em cima de um Mini",
            modifier = Modifier
                .padding(end = 15.dp)
                .height(72.dp)
        )

        Column {
            Text(
                text = "Mini Cooper 1989",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            Text("1989 - 420.000km - £ 100.000")

            Text(
                text = "Auto | GPL | 12 px",
                color = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListItemPreview() {
    StandXTheme {
        CarListItem()
    }
}
