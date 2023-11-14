package com.example.compose_tutorial

import android.os.Bundle
import android.print.PrintAttributes.Margins
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_tutorial.ui.theme.Compose_tutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            Column(
//                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier
//                    .fillMaxSize(22f)
//                    .background(Color.Cyan),
//                verticalArrangement = Arrangement.SpaceEvenly
//            ) {
//                Text(text = "hello")
//                Text(text = "Android")
//                Text(text = "Android")
//
//            }

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .width(300.dp)
                    .fillMaxHeight(0.8f)
                    .background(Color.Cyan),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "hello")
                Text(text = "Android")
                Text(text = "Android")

            }

        }
    }
}


@Preview(showBackground = true, showSystemUi = false)
@Composable
fun GreetingPreview() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "hello")
        Text(text = "Android")
    }
}