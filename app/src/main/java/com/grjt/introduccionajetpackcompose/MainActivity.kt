package com.grjt.introduccionajetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    var num by rememberSaveable {
        mutableStateOf(0)
    }

    Column {
        Text("Conteo: $num")

        Divider(thickness = 20.dp, color = Color.Transparent)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Counter(
                btnTitle = "Aumentar conteo",
                updateCount = {
                    num++
                }
            )

            Counter(
                btnTitle = "Disminuir conteo",
                updateCount = {
                    num--
                }
            )
        }
    }
}

@Composable
fun Counter(
    btnTitle: String,
    updateCount: () -> Unit
) {
    Button(
        onClick = {
            updateCount()
        }
    ) {
        Text(btnTitle)
    }
}

@Preview(
    showBackground = true,
    name = "JetpackCompose",
    showSystemUi = true,
    device = Devices.DEFAULT
)
@Composable
fun DefaultPreview() {
    SimpleComposable()
}