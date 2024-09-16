package com.example.proxymate.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.proxymate.model.cardDetails


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddSubjectDailog(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    onConfirm: (cardDetails) -> Unit
){

    var subjectName by remember {
        mutableStateOf("")
    }
    var subjectlist: MutableList<cardDetails> = mockCardDetails
    if(showDialog){
        AlertDialog(onDismissRequest = {onDismiss()
                                       subjectName = ""},
            confirmButton = {
                TextButton(
                    onClick = {
                    if(subjectName.isNotEmpty()){
                        var newSubject = cardDetails(
                            subjectName = subjectName,
                            classAttended = 0,
                            classMissed = 0
                        )
                        onConfirm(newSubject)
                        subjectName =""
                        subjectlist = (subjectlist + newSubject).toMutableList()
                    }
                }) {
                    Text("Add")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    onDismiss()
                    subjectName = ""
                }) {
                    Text(text = "Cancel")
                }
            },
            title = {Text("Add a new Subject")},
            text = {
                Column(modifier = Modifier.padding(8.dp),
                    horizontalAlignment = Alignment.Start) {
                    OutlinedTextField(
                        value = subjectName,
                        onValueChange ={subjectName = it},
                        singleLine = true,
                        label = {Text("Subject Name")})
                }
            })
    }
}