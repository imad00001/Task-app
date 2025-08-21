package com.example.taskapp.phase3

import android.icu.text.CaseMap
import android.icu.text.CaseMap.Title
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

//@Composable
//fun AlertDialogBox() {
//    val context = LocalContext.current
//Box(
//    modifier = Modifier.fillMaxSize().height(350.dp).padding(16.dp),
//    contentAlignment = Alignment.Center
//){
//
//    Dialog(
//        onDismissRequest = {
//
//        },
//    ) {
//        Card(
//            modifier = Modifier.fillMaxWidth()
//                .padding(16.dp),
//            shape = RoundedCornerShape(16.dp)
//
//
//        ){
//            Text(text = "This is an Alert Dialog Box",
//                modifier = Modifier.padding(16.dp))
//
//
//        }
//    }
//
//
//}
//}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogBox(
    onDismiss: () -> Unit,
    onConfirm: (String,String) -> Unit
) {
    val context = LocalContext.current


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        AlertDialog(
            onDismissRequest = {onDismiss()},
            title = { Text(text = "Alert Dialog") },

            }
        )
            }

    }



@Preview(showSystemUi = true)
@Composable
fun AlertDialogBoxPreview() {
    AlertDialogBox()
}