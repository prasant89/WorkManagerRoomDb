package com.prasant.workmanagerroomdb

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.Composable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign


class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column{
                SimpleButtonComponent()
                Divider(color = Color.Cyan)
                SimpleTextComponent()
                Divider(color = Color.Gray)
                SimpleCardComponent()
                Divider(color = Color.Gray)
            }



                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(10.dp)) {
                    Card(
                        shape = RoundedCornerShape(4.dp),
                        colors = CardDefaults.cardColors(containerColor =  MaterialTheme.colorScheme.surfaceVariant),
                        modifier = Modifier.fillMaxWidth())
                    {
                        Column(modifier = Modifier.padding(10.dp)) {
                            Text("PRASANT", fontWeight = FontWeight.W700)
                            Text("KUMAR")
                            Text("PRADHAN", color = Color.Gray)
                        }
                    }
                }
            }
        }
    }



@Composable
fun SimpleButtonComponent(){
    val context = LocalContext.current
    Button(
        onClick = {
            Toast.makeText(context, "Thanks for clicking! I am Button", Toast.LENGTH_SHORT).show()
        },
        modifier = Modifier.padding(16.dp).fillMaxWidth()
    ) {
        Text("Click Me")
    }
}


@Composable
fun SimpleTextComponent() {
    val context = LocalContext.current
    Text(
        text = "Click Me",
        textAlign = TextAlign.Center,
        color = Color.Black,
        modifier = Modifier.padding(16.dp).fillMaxWidth().clickable(onClick = {
            Toast.makeText(context, "Thanks for clicking! I am Text", Toast.LENGTH_SHORT).show()
        })
    )
}

@Composable
fun SimpleCardComponent() {
    val context = LocalContext.current
    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier.padding(16.dp).fillMaxWidth().clickable(onClick = {
            Toast.makeText(context, "Thanks for clicking! I am Card.", Toast.LENGTH_SHORT).show()
        })
    ) {
        Text(
            text = "Click Me",
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 16.sp
            ),
            modifier = Modifier.padding(16.dp)
        )
    }
}

