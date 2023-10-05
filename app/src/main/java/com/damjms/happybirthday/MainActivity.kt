package com.damjms.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.layout.ContentScale
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Greeting()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting() {
    Box (modifier = Modifier.fillMaxSize()){
        //rememberSaveable por si rota la pantalla
        var texto by rememberSaveable { mutableStateOf("") }
        var nombre by rememberSaveable { mutableStateOf("") }
        Image(
            painter = painterResource(id = R.drawable.androidparty),
            contentDescription = "fondo",
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        )
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "Ingresa tu nombre",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                fontStyle = FontStyle.Italic
            )

            OutlinedTextField(
                value = texto,
                onValueChange = {texto = it},
                label = { Text(text = "Introduce nombre")}
            )

            Button(onClick = { nombre = texto }) {
                Text(text = "PULSAME")
            }
            Text(text = nombre, textAlign = TextAlign.Center)
        }
    }
}