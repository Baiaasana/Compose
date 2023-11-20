package com.example.compose_tutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_tutorial.ui.theme.Compose_tutorialTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            Compose_tutorialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        MyUI2()
                    }
                }
            }
        }
    }


}

@Composable
fun Snackbar(
    modifier: Modifier = Modifier, content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(2.dp),
        color = Color.Gray, // You can set the background color as per your design
    ) {
        content()
    }
}

// snackbar
@Composable
fun MyUI() {
    // to display and hide the snackbar
    var showSnackbar by remember {
        mutableStateOf(false)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Button(modifier = Modifier.align(alignment = Alignment.Center), // keep the button at the center of the screen
            onClick = { showSnackbar = !showSnackbar }) {
            Text(text = "${if (showSnackbar) "Hide" else "Show"} Snackbar")
        }

        if (showSnackbar) {
            Snackbar(
                modifier = Modifier
                    .padding(all = 8.dp)
                    .align(alignment = Alignment.BottomCenter) // show the snackbar at the bottom of the screen
            ) {
                Text(text = "Hello Android!")
            }
        }
    }
}

// snackBar with Scaffold
// Scaffold may be used for also navigation drawer toolbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyUI2() {


    val snackBarHostState = remember { SnackbarHostState() }
    var textFieldState by remember {      // snackis text
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()

    Scaffold(modifier = Modifier.fillMaxSize(),
        snackbarHost = { SnackbarHost(snackBarHostState) }) {
        // rest of the app's UI
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = it.calculateBottomPadding()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                // text field
                value = textFieldState,
                label = {
                    Text(text = "Enter your name")
                },
                onValueChange = {
                    textFieldState = it
                },

                singleLine = true,
                modifier = Modifier.run {
                    fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .background(
                            shape = RoundedCornerShape(corner = CornerSize(10.dp)),
                            color = MaterialTheme.colorScheme.background
                        )
                },
                trailingIcon = {                          // { Composable() -> {}}  
                    Icon(Icons.Default.Clear,
                        contentDescription = "Clear Text",
                        modifier = Modifier.clickable {
                            textFieldState = ""
                        })
                },
                supportingText = {
                    Text(
                        text = "*Required Field",
                        modifier = Modifier.fillMaxWidth(),
                        color = Color.Red
                    )
                },
                placeholder = {
                    Text("Hint", color = Color.Gray)
                },
                isError = false,
                visualTransformation = VisualTransformation { it ->            // for formatting   // CreditCardOffsetTranslator().dsds(it)  ***********
                    CreditCardOffsetTranslator().FIFQEBI(it)
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number, capitalization = KeyboardCapitalization.None
                ),
            )

            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {

                if (textFieldState == "") {
                    textFieldState = "Android"
                }
                scope.launch {
                    snackBarHostState.showSnackbar(
                        message = "Hello $textFieldState!",
                        duration = SnackbarDuration.Short,
                        actionLabel = "Hide"
                    )
                }
            }) {
                Text(text = "please great me!")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun GreetingPreview() {
    MyUI2()
}






