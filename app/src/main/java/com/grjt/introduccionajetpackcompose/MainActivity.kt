package com.grjt.introduccionajetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    var textFieldValue by remember { mutableStateOf("") }
    var textValue by remember { mutableStateOf("Título de la aplicación") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            painter = painterResource(id = R.drawable.bg),
            contentDescription = "Imagen de fondo",
            contentScale = ContentScale.FillWidth
        )

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = textValue,
            style = TextStyle(
                color = Color.Green,
                fontSize = 28.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Black,
                textAlign = TextAlign.Center
            )
        )

        TextField(
            value = textFieldValue,
            onValueChange = { newText ->
                textFieldValue = newText
            },
            label = {
                Text("Inserte texto aquí")
            },
            leadingIcon = {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.ic_android),
                    contentDescription = "Icono"
                )
            }
        )

        Button(
            onClick = {
                textValue = textFieldValue
            }
        ) {
            Text("Aceptar")
        }
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