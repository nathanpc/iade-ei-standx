package pt.iade.ei.standx.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import pt.iade.ei.standx.ui.theme.StandXTheme

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
