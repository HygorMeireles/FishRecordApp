package br.com.fishrecord.impl.ui.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.fishrecord.theme.color.FRColor
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource


private const val NAVIGATE_DELAY = 1000L

@Composable
fun SplashScreen(
    navigateTo: () -> Unit
) {
    LaunchedEffect(Unit) {
        delay(NAVIGATE_DELAY)
        navigateTo.invoke()
    }

    Column(
        modifier = Modifier.fillMaxSize().background(FRColor.primary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Coloca uma imagem aqui.")
    }
}
