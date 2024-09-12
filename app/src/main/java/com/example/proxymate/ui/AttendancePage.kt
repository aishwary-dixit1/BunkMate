package com.example.proxymate.ui

import android.provider.SyncStateContract.Columns
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.proxymate.model.cardDetails

class AttendancePage {


}
val mockCardDetails:  List<cardDetails> = listOf(
    cardDetails("Algorithm", 5, 0),
    cardDetails("Python", 5, 10),
    cardDetails("Architecture", 5, 0),
    cardDetails("Computation", 5, 0),
    cardDetails("HS", 5, 0)
)
@Composable
fun AttendanceCard(subjectDetails: cardDetails){

    val redColor = Color.Red // Your original color
    val transparentRedColor = redColor.copy(alpha = 0.2f)

    val greenColor = Color.Green // Your original color
    val transparentGreenColor = greenColor.copy(alpha = 0.2f)

    Box(modifier = Modifier
        .fillMaxWidth()
        .height(275.dp)
        .padding(horizontal = 4.dp)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 4.dp)
        ) {
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(10.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Row(modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
                ) {
                    Box(modifier = Modifier.weight(1f)
                    ){
                        Column(modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp)
                        ) {
                            Box(modifier = Modifier.weight(0.7f)
                            ){
                                Text(text = subjectDetails.subjectName,
                                    style = MaterialTheme.typography.headlineSmall)
                            }
                            Box(modifier = Modifier.weight(1f)
                            ){
                                Column {
                                    Box(modifier = Modifier.weight(1f)
                                    ){
                                        Row(verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.Center) {
                                            Text(text = "${subjectDetails.classAttended}", style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold))
                                            Spacer(modifier = Modifier.width(6.dp))
                                            Text(text = "Attended", style = MaterialTheme.typography.bodyMedium)
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Box(modifier = Modifier.weight(1f)
                                    ){
                                        Row(verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.Center) {
                                            Text(text = "${subjectDetails.classMissed}", style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold))
                                            Spacer(modifier = Modifier.width(6.dp))
                                            Text(text = "Missed", style = MaterialTheme.typography.bodyMedium)
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Box(modifier = Modifier.weight(1f)
                                    ){
                                        Row(verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.Center) {
                                            Text(text = "${subjectDetails.classAttended + subjectDetails.classMissed}", style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold))
                                            Spacer(modifier = Modifier.width(6.dp))
                                            Text(text = "Total", style = MaterialTheme.typography.bodyMedium)
                                        }
                                    }
                                }
                            }
                            Box(modifier = Modifier.weight(0.6f),
                                contentAlignment = Alignment.BottomCenter
                            ){
                                if((subjectDetails.classMissed + 1) < (0.25 * (subjectDetails.classAttended + subjectDetails.classMissed ))){
                                    //val numberOfClassCanSkip : Int = subjectDetails
                                    Text(text = "Can Skip Next 1", style = MaterialTheme.typography.titleSmall)
                                }
                                else {
                                    Text(text = "Cannot Skip", style = MaterialTheme.typography.titleSmall)
                                }

                            }
                        }
                    }
                    Box(modifier = Modifier.weight(1f)
                    ){

                    }
                }

            }
            Row (modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp)

            ) {
                Box(modifier = Modifier.weight(1f)){
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(modifier = Modifier.weight(0.6f)
                        ){
                            Text(text = "Attended", style = MaterialTheme.typography.titleSmall)

                        }
                        Box(modifier = Modifier.weight(1f)){
                            Row {
                                OutlinedButton(onClick = { /*TODO*/ },
                                    modifier = Modifier.size(width = 35.dp, height = 30.dp),
                                    border = BorderStroke(2.dp, Color.Green),
                                    contentPadding = PaddingValues(0.dp),
                                    colors = ButtonDefaults.outlinedButtonColors(
                                        contentColor = Color.Green,
                                        containerColor = transparentGreenColor
                                    )) {
                                    Icon(
                                        imageVector = Icons.Filled.Add,
                                        contentDescription = "AttendedAdd",
                                        tint= Color.Green,
                                        modifier = Modifier.size(25.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.width(12.dp))
                                OutlinedButton(onClick = { /*TODO*/ },
                                    modifier = Modifier.size(width = 35.dp, height = 30.dp),
                                    border = BorderStroke(2.dp, Color.Red),
                                    contentPadding = PaddingValues(0.dp),
                                    colors = ButtonDefaults.outlinedButtonColors(
                                        contentColor = Color.Red,
                                        containerColor = transparentRedColor
                                    )) {
                                    Icon(
                                        imageVector = Icons.Filled.Close,
                                        contentDescription = "AttendedMinus",
                                        tint= Color.Red,
                                        modifier = Modifier.size(25.dp)
                                    )
                                }
                            }
                        }
                    }

                }
                Box(modifier = Modifier.weight(0.8f).padding(vertical = 12.dp),
                    contentAlignment = Alignment.BottomCenter){
                    OutlinedButton(onClick = { /*TODO*/ },
                        border = BorderStroke(2.dp, Color.Red),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = Color.Red,
                            containerColor = transparentRedColor
                        )) {
                        Text(text = "Delete")
                    }

                }
                Box(modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterEnd
                ){
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(modifier = Modifier.weight(0.6f)
                        ){
                            Text(text = "Missed", style = MaterialTheme.typography.titleSmall)

                        }
                        Box(modifier = Modifier.weight(1f)){
                            Row {
                                OutlinedButton(onClick = { /*TODO*/ },
                                    modifier = Modifier.size(width = 35.dp, height = 30.dp),
                                    border = BorderStroke(2.dp, Color.Green),
                                    contentPadding = PaddingValues(0.dp),
                                    colors = ButtonDefaults.outlinedButtonColors(
                                        contentColor = Color.Green,
                                        containerColor = transparentGreenColor
                                    )) {
                                    Icon(
                                        imageVector = Icons.Filled.Add,
                                        contentDescription = "Add",
                                        tint= Color.Green,
                                        modifier = Modifier.size(25.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.width(12.dp))
                                OutlinedButton(onClick = { /*TODO*/ },
                                    modifier = Modifier.size(width = 35.dp, height = 30.dp),
                                    contentPadding = PaddingValues(0.dp),
                                    border = BorderStroke(2.dp, Color.Red),
                                    colors = ButtonDefaults.outlinedButtonColors(
                                        contentColor = Color.Red,
                                        containerColor = transparentRedColor
                                    )) {
                                    Icon(
                                        imageVector = Icons.Filled.Close,
                                        contentDescription = "Add",
                                        tint= Color.Red,
                                        modifier = Modifier.size(25.dp)
                                    )
                                }
                            }
                        }
                    }

                }
            }
        }
        
    }
    
}

@Preview(showBackground = true)
@Composable
fun AttendancePageCardPreview(){
    AttendanceCard(mockCardDetails[0])
}
