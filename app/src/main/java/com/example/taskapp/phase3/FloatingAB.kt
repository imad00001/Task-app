//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Add
//import androidx.compose.material3.AlertDialog
//import androidx.compose.material3.FloatingActionButton
//import androidx.compose.material3.Icon
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextButton
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.tooling.preview.Preview
//import com.example.taskapp.phase2.Task
//
//
//@Composable
//fun FloatingAB(
//    onConfirm: (String, String) -> Unit
//) {
//    var showDialog by remember { mutableStateOf(false) }
//    var taskTitle by remember { mutableStateOf("") }
//    var taskDescription by remember { mutableStateOf("") }
//FloatingActionButton(onClick = {showDialog = true}) {
//
//    Icon(
//        imageVector = Icons.Default.Add,
//        contentDescription = "Add Task",
//        tint = Color.Black
//    )
//}
//    if (showDialog) {
//        AlertDialog(
//            onDismissRequest = { showDialog = false },
//            title = { Text("Title") },
//            text = {
//                Column {
//                    OutlinedTextField(
//                        value = taskTitle,
//                        onValueChange = { taskTitle = it },
//                        label = { Text("Title") },
//                        modifier = Modifier.fillMaxWidth()
//
//                    )
//
//                    OutlinedTextField(
//                        value = taskDescription,
//                        onValueChange = { taskDescription = it },
//                        label = { Text("Description") },
//                        modifier = Modifier.fillMaxWidth()
//
//                    )
//                }
//
//
//            },
//            confirmButton = {
//                TextButton(
//                    onClick = {
//
//                        if (taskTitle.isNotBlank()) {
//                            onConfirm(taskTitle, taskDescription)
//
//                            // reset fields
//                            taskTitle = ""
//                            taskDescription = ""
//                            showDialog = false
//                        }
//                    }
//                ) {
//                    Text("confirm", color = Color.Black)
//                }
//            },
//            dismissButton = {
//                TextButton(onClick = { showDialog = false }) {
//                    Text("cancel")
//                }
//            }
//        )
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun FloatingABPreview() {
//    FloatingAB { title, description -> }
//}
//// //    TaskAppDrawer()