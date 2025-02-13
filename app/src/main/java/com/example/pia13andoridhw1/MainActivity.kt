package com.example.pia13andoridhw1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pia13andoridhw1.ui.theme.PIA13AndoridHW1Theme

val HWGreen = Color(0xFF63C466)
val HWCyan = Color(0xFF59C4F6)
val HWRed = Color(0xFFEA4E3D)

/*
Plus och minus ökar/minskar siffran i mitten med 1.
Siffran i mitten börjar på noll.
Om siffran är noll så visas inte minus-knapp.
Om siffran är större än 10 så visas inte plus-knapp.
Marginaler och färger måste inte vara exakt.
Lägg allt i MainActivity. Gör ny gist på gist.github.com med innehållet i MainActivity. Klistra in länk till gist nedan.
*/

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PIA13AndoridHW1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HW(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun HW(name: String, modifier: Modifier = Modifier) {
    var number by remember { mutableStateOf(0) }
    var showPlus by remember { mutableStateOf(true) }
    var showMinus by remember { mutableStateOf(false) }

    fun checkState() {
        if (number > 10) {
            showPlus = false
        } else if (number == 0) {
            showMinus = false
        } else {
            showPlus = true
            showMinus = true
        }
    }

    fun plus() {
        number++
        checkState()
    }
    fun minus() {
        number--
        checkState()
    }

    Text(
        text = "Hello $name!",
        modifier = modifier
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(HWCyan)
            .padding(vertical = 5.dp),
                horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(HWGreen)
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "UPPGIFT 1",
                color = Color.Black,
                fontSize = 35.sp
            )
        }
        Column(
            modifier = Modifier
                .padding(vertical = 124.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (showPlus) {
                Box(
                    modifier = Modifier
                    .clickable {
                        plus()
                    }
                    .background(HWRed)
                    .padding(vertical = 10.dp)
                    .width(169.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("PLUS", fontSize = 35.sp)
                }
            }
            Text(text = number.toString(), fontSize = 124.sp)
            if (showMinus) {
                Box(
                    modifier = Modifier
                    .clickable {
                        minus()
                    }
                    .background(HWRed)
                    .padding(vertical = 10.dp)
                    .width(169.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("MINUS", fontSize = 35.sp)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PIA13AndoridHW1Theme {
        HW("Android")
    }
}