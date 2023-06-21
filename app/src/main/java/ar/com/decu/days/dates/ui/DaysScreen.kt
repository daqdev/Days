package ar.com.decu.days.dates.ui

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.com.decu.days.dates.DatesViewModel
import ar.com.decu.days.dates.data.net.model.DatesModel

@Composable
fun DaysScreen(datesViewModel: DatesViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Header(Modifier.align(Alignment.TopEnd))
        Body(Modifier.align(Alignment.Center), datesViewModel)
    }
}

@Composable
fun Body(modifier: Modifier, datesViewModel: DatesViewModel) {

    val dates: DatesModel by datesViewModel.result.observeAsState(
        initial = DatesModel(
            "",
            0,
            "",
            0
        )
    )

    Column(modifier = modifier) {
        DataCard("30 Dias", dates.days30.toString(), dates.day30, 30)
        Spacer(Modifier.height(12.dp))
        DataCard("90 Dias", dates.days90.toString(), dates.day90, 90)
    }
}

@Composable
fun DataCard(title: String, totalDays: String, finalDate: String, diasTitle: Number) {
    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .padding(12.dp)
            .wrapContentHeight(),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(2.dp)
        ) {
            TitleCard(text = title, Modifier.padding(1.dp))
            Divider(Modifier.fillMaxWidth())
            Text(
                text = "Dias hasta el proximo Viernes en $diasTitle dias: $totalDays",
                color = Color.Black
            )
            Text(text = finalDate, color = Color.Black)
        }
    }
}

@Composable
fun TitleCard(text: String, modifier: Modifier) {
    Text(
        text = text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        color = Color.Black,
        modifier = modifier
    )
}

@Composable
fun Header(modifier: Modifier) {
    val activity = LocalContext.current as Activity
    Icon(
        imageVector = Icons.Default.Close,
        contentDescription = "Close App",
        modifier = modifier.clickable { activity.finish() })
}
