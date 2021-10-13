package com.grjt.introduccionajetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
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

data class Product(
    val name: String,
    val price: Double
)

data class Advertising(
    val title: String
)

private val listProducts = listOf(
    Product(name = "Manzana", price = 18.99),
    Product(name = "Carne", price = 180.00),
    Product(name = "Leche", price = 24.50),
    Product(name = "Pescado", price = 75.39),
    Product(name = "Huevo", price = 64.89),
    Product(name = "Cereal", price = 32.99),
    Product(name = "Naranja", price = 28.50),
    Product(name = "Café", price = 72.00),
    Product(name = "Jabón", price = 33.19),
    Product(name = "Harina", price = 41.99),
    Product(name = "Aceite", price = 19.00),
    Product(name = "Agua", price = 55.99),
    Product(name = "Camisa", price = 228.49),
    Product(name = "Arroz", price = 37.50),
    Product(name = "HERSHEY'S", price = 15.50),
    Product(name = "Miel", price = 82.00),
    Product(name = "Atún", price = 16.90),
    Product(name = "Galletas", price = 41.00),
    Product(name = "Pan", price = 38.90),
    Product(name = "KitKat", price = 22.00),
    Product(name = "Nutella", price = 29.49),
    Product(name = "Crunch", price = 17.00),
    Product(name = "Panditas", price = 15.50),
)

private val listAdvertising = listOf(
    Advertising("Advertising 1"),
    Advertising("Advertising 2"),
    Advertising("Advertising 3"),
    Advertising("Advertising 4")
)

@Composable
fun SimpleComposable() {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            Text(
                text = "Productos del supermercado",
                style = TextStyle(
                    color = Color.Blue,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Black
                )
            )
        }

        /* items(listProducts) {
            ProductDesign(product = it)
        } */

        itemsIndexed(listProducts) { position, product ->
            if(position%5 == 0 && position != 0){
                LazyRow {
                    items(listAdvertising) {
                        AdvertisingDesign(advertising = it)
                    }
                }
            } else {
                ProductDesign(product = product)
            }
        }
    }
}

@Composable
fun ProductDesign(product: Product) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = product.name,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        )

        Text(
            text = "${product.price}.00 MXN",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Light,
                fontStyle = FontStyle.Italic
            )
        )
    }
}

@Composable
fun AdvertisingDesign(advertising: Advertising) {
    Box(
        modifier = Modifier
            .padding(end = 8.dp)
            .size(140.dp)
            .clip(RoundedCornerShape(12))
            .background(color = Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = advertising.title,
            style = TextStyle(
                fontWeight = FontWeight.Black
            )
        )
    }
}
