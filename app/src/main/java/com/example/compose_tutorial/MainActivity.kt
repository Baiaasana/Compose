package com.example.compose_tutorial

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Column(modifier = Modifier.fillMaxSize()) {
                // at recomposition it does not update state, but remember initial value

                val color = remember {
                    mutableStateOf(Color.Yellow)
                }
                ColoredBox(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxSize()
                ) {
                    Log.d("recompose", it.toString())
                    color.value = it
                }
                Box(
                    modifier = Modifier
                        .background(color.value)
                        .weight(1f)
                        .fillMaxSize()
                )

            }
        }
    }
}

// recomposition  - call the composable function again with new data , redraw widgets
// Compose is declarative and as such the only way to update it is by calling the same composable with new arguments.
//
//Composition: a description of the UI built by Jetpack Compose when it executes composables.
//
//Initial composition: creation of a Composition by running composables the first time.
//
//Recomposition: re-running composables to update the Composition when data changes.

@Composable
fun ColoredBox(
    modifier: Modifier = Modifier,
    updateColor: (Color) -> Unit
) {

    Box(modifier = modifier
        .background(Color.Red)
        .clickable {
            updateColor(
                Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )
            )
        }
    )
}

