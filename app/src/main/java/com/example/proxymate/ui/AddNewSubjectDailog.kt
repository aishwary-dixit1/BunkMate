package com.example.proxymate.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proxymate.model.cardDetails
import kotlin.reflect.KProperty

@Composable
fun AddNewSubjectDailog(showDailog : Boolean){

    var showDailogDailog by remember{
        mutableStateOf(false)
    }
    var subjectList  = mockCardDetails

    var newSubjectName by remember {
        mutableStateOf("")
    }
    var newClassAttended by remember {
        mutableStateOf("")
    }
    var newClassMissed  by remember {
        mutableStateOf("")
    }
    if(showDailog){
        AlertDialog(onDismissRequest = {showDailogDailog = false},
            modifier = Modifier.background(color = Color.Black),
            confirmButton = {
//                Text(text = "Add", style = MaterialTheme.typography.titleMedium)
//                if(newSubjectName.isNotEmpty()){
//                    val newSubject = cardDetails(
//                        newSubjectName,
//                        newClassAttended.toInt(),
//                        newClassMissed.toInt()
//                    )
//                    subjectList = (subjectList + newSubject).toMutableList()
//                }
//                showDailogDailog = false
            },
            dismissButton = {
//                Text(text = "Cancel", style = MaterialTheme.typography.titleMedium)
//                showDailogDailog = false
            },
        title = {Text(text = "Add a New Subject")},
            text = {
                Column {
                    OutlinedTextField(value = newSubjectName,
                        onValueChange ={newSubjectName = it},
                        singleLine = true,
                        label = { Text("New subject name") } )
                    OutlinedTextField(value = newClassAttended,
                        onValueChange ={newClassAttended = it},
                        singleLine = true,
                        label = { Text("Class attended") } )
                    OutlinedTextField(value = newClassMissed,
                        onValueChange ={newClassMissed = it},
                        singleLine = true,
                        label = { Text("Class missed") } )
                    Spacer(modifier = Modifier.height(12.dp))
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(onClick = { showDailogDailog = false },
                            colors = ButtonDefaults.buttonColors(Color.Black)) {
                            Text(text = "Cancel", style = MaterialTheme.typography.titleMedium)
                        }
                        Button(onClick = {
                            if(newSubjectName.isNotEmpty()){
                                val newSubject = cardDetails(
                                    newSubjectName,
                                    newClassAttended.toInt(),
                                    newClassMissed.toInt()
                                )
                                subjectList = (subjectList + newSubject).toMutableList()
                            }
                            showDailogDailog = false },
                            colors = ButtonDefaults.buttonColors(Color.Black)) {
                            Text(text = "Add", style = MaterialTheme.typography.titleMedium)
                        }

                    }

                }
            })
    }
}

@Preview
@Composable
fun PreviewAddNewSubjectDailog(){
    AddNewSubjectDailog(showDailog = true)
}


