package com.example.taskapp.phase2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TaskChips() {
    val Chip = remember {
        listOf(
            "All",
            "Completed",
            "Pending",
            "Today",
        )
        }
    var selectedCategory by remember{ mutableStateOf("All") }

    Column (
        modifier = Modifier.fillMaxSize().padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Chip.forEach{
            label ->
            FilterChip(
               selected = (selectedCategory == label),
                onClick = { selectedCategory = label},
                label = { Text(label)}
            )

        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun TaskChipsPreview() {
    TaskChips()
}
