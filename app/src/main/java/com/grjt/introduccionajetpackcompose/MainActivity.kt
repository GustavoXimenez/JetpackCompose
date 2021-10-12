package com.grjt.introduccionajetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.grjt.introduccionajetpackcompose.ui.theme.IntroduccionAJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroduccionAJetpackComposeTheme {
                SimpleComposable()
            }
        }
    }
}

@Composable
fun SimpleComposable() {
    val checkState = remember { mutableStateOf(false) }

    Column {
        Text("Hola mundo")
        Checkbox(checked = checkState.value, onCheckedChange = {
            checkState.value = !checkState.value
        })
    }
}

@Preview(showBackground = true, name = "JetpackCompose", showSystemUi = true, device = Devices.DEFAULT)
@Composable
fun DefaultPreview() {
    SimpleComposable()
}