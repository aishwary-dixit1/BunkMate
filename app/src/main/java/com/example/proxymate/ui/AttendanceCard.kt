package com.example.proxymate.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proxymate.model.cardDetails
var mockCardDetails:  MutableList<cardDetails> = mutableListOf(
    cardDetails("Algorithm", 5, 0),
    cardDetails("Python", 5, 10),
    cardDetails("Architecture", 5, 0),
    cardDetails("Computation", 5, 0),
    cardDetails("HS", 5, 0)
)
@Composable
fun AttendanceCard(subjectDetails: cardDetails){

    var classAttended by remember{ mutableStateOf(subjectDetails.classAttended)}
    var classMissed by remember { mutableStateOf(subjectDetails.classMissed) }

    var classAttendedFloat: Float = classAttended.toFloat()
    var classMissedFloat: Float = classMissed.toFloat()
    var attendancePercentage by remember {
        mutableStateOf(classAttendedFloat/(classAttendedFloat + classMissedFloat))
    }
    val royalBlue = Color(0xFF007FFF)

    var progressBarColor by remember{ mutableStateOf( when {
            attendancePercentage < 0.5f -> Color.Red
            attendancePercentage < 0.75f -> Color.Yellow
            else -> Color.Green
        }
    )}
    val redColor = Color.Red // Your original color
    val transparentRedColor = redColor.copy(alpha = 0.2f)

    val greenColor = Color.Green // Your original color
    val transparentGreenColor = greenColor.copy(alpha = 0.2f)

    Box(modifier = Modifier
        .fillMaxWidth()
        .height(302.dp)
        .padding(horizontal = 4.dp)
        .padding(vertical = 16.dp)
        .background(color = Color.Black)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 4.dp)
        ) {
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.DarkGray),
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
                                    style = MaterialTheme.typography.headlineSmall.copy(color = Color.White))
                            }
                            Box(modifier = Modifier.weight(1f)
                            ){
                                Column {
                                    Box(modifier = Modifier.weight(1f)
                                    ){
                                        Row(verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.Center) {
                                            Text(text = "${classAttended}", style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold, color = Color.White))
                                            Spacer(modifier = Modifier.width(6.dp))
                                            Text(text = "Attended", style = MaterialTheme.typography.bodyMedium.copy(color = Color.White))
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Box(modifier = Modifier.weight(1f)
                                    ){
                                        Row(verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.Center) {
                                            Text(text = "${classMissed}", style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold, color = Color.White))
                                            Spacer(modifier = Modifier.width(6.dp))
                                            Text(text = "Missed", style = MaterialTheme.typography.bodyMedium.copy(color = Color.White))
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Box(modifier = Modifier.weight(1f)
                                    ){
                                        Row(verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.Center) {
                                            Text(text = "${classAttended + classMissed}", style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold, color = Color.White))
                                            Spacer(modifier = Modifier.width(6.dp))
                                            Text(text = "Total", style = MaterialTheme.typography.bodyMedium.copy(color = Color.White))
                                        }
                                    }
                                }
                            }
                            Box(modifier = Modifier.weight(0.6f),
                                contentAlignment = Alignment.BottomCenter
                            ){
                                if((classMissed + 1) < (0.25 * (classAttended + classMissed ))){
                                    //val numberOfClassCanSkip : Int = subjectDetails
                                    Text(text = "Can Skip Next 1", style = MaterialTheme.typography.titleSmall.copy(color = Color.White))
                                }
                                else {
                                    Text(text = "Cannot Skip", style = MaterialTheme.typography.titleSmall.copy(color = Color.White))
                                }

                            }
                        }
                    }
                    Box(modifier = Modifier
                        .weight(1f)
                        .padding(30.dp),
                        contentAlignment = Alignment.Center
                    ){

                        CircularProgressIndicator(
                            progress = (classAttendedFloat/(classAttendedFloat + classMissedFloat)).toFloat(),
                            modifier = Modifier.size(100.dp),
                            color = progressBarColor,
                            strokeWidth = 8.dp,
                            strokeCap = StrokeCap.Round
                            )
                        Text(text = "${((classAttendedFloat/(classAttendedFloat + classMissedFloat))* 100).toInt()}%",
                            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold, color = Color.White),
                            modifier = Modifier.align(Alignment.Center))
                    }
                    }

            }
            Row (modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Box(modifier = Modifier.weight(1f)){
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(modifier = Modifier.weight(0.6f)
                        ){
                            Text(text = "Attended", style = MaterialTheme.typography.titleSmall.copy(color = Color.White))

                        }
                        Box(modifier = Modifier.weight(1f)){
                            Row {
                                OutlinedButton(onClick = {
                                    classAttended++
                                    subjectDetails.classAttended++
                                    attendancePercentage = (classAttendedFloat/(classAttendedFloat + classMissedFloat))
                                    progressBarColor = when {
                                        attendancePercentage < 0.5f -> Color.Red
                                        attendancePercentage < 0.75f -> Color.Yellow
                                        else -> Color.Green
                                    }
                                },
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
                                OutlinedButton(onClick = {
                                    classAttended--
                                    subjectDetails.classAttended--
                                    attendancePercentage = (classAttendedFloat/(classAttendedFloat + classMissedFloat))
                                    progressBarColor = when {
                                        attendancePercentage < 0.5f -> Color.Red
                                        attendancePercentage < 0.75f -> Color.Yellow
                                        else -> Color.Green
                                    }
                                },
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
                Box(modifier = Modifier
                    .weight(0.8f)
                    .padding(vertical = 12.dp),
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
                            Text(text = "Missed", style = MaterialTheme.typography.titleSmall.copy(color = Color.White))

                        }
                        Box(modifier = Modifier.weight(1f)){
                            Row {
//                                Card(modifier = Modifier.padding(2.dp).background(color = Color.Transparent),
//                                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
//                                ) {
                                    OutlinedButton(onClick = {
                                        classMissed++
                                        subjectDetails.classMissed++
                                        attendancePercentage = (classAttendedFloat/(classAttendedFloat + classMissedFloat))
                                        progressBarColor = when {
                                            attendancePercentage < 0.5f -> Color.Red
                                            attendancePercentage < 0.75f -> Color.Yellow
                                            else -> Color.Green
                                        }
                                    },
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
                                //}

                                Spacer(modifier = Modifier.width(12.dp))
                                OutlinedButton(onClick = {
                                    classMissed--
                                    subjectDetails.classMissed--
                                    attendancePercentage = (classAttendedFloat/(classAttendedFloat + classMissedFloat))
                                    progressBarColor = when {
                                        attendancePercentage < 0.5f -> Color.Red
                                        attendancePercentage < 0.75f -> Color.Yellow
                                        else -> Color.Green
                                    }
                                },
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