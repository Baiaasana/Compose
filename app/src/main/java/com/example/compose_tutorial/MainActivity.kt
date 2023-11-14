package com.example.compose_tutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .background(Color.Cyan)
                    .fillMaxHeight(0.5f)
//                    .width(100.dp)     // custom width
//                    .requiredWidth(600.dp)    // gadis screens garet
                    .fillMaxWidth()
//                    .padding(20.dp)
                    .border(10.dp, Color.Blue, shape = RectangleShape)
                    .padding(10.dp)
                    .border(10.dp, Color.Red)
                    .padding(10.dp)
                    .border(10.dp, Color.Blue)                  // yuradgeba miaqcie orders
                    .padding(10.dp)
                    .border(10.dp, Color.Red)
                    .padding(10.dp)


            ) {
                Text(
                    text = "Hello", modifier = Modifier.clickable {
                        // click event
                    }
                )     // top left paddings  // do not have margins / diff - offsetit gadaefareba ertmanets(ashorebs mxolod sakutari kidedan). margin ashorebda ertmanetisgan
                Spacer(modifier = Modifier.height(60.dp))  // just space
                Text(text = "Android!", modifier = Modifier.offset(20.dp))
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