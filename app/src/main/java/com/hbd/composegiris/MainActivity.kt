package com.hbd.composegiris

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hbd.composegiris.ui.theme.ComposeGirisTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeGirisTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DogumGunuKartiResmi(message = "Hello Zeynep", from = "-from Hasan")
                }
            }
        }
    }
}
@Composable
fun DogumGunuKartiResmi(message: String, from: String) {
    val image = painterResource(R.drawable.androidparty) // çizici kaynağı getiriyor

    Box {
        Image(
            painter = image,
            contentDescription = "Dogum günü kartı",   // null
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            contentScale = ContentScale.Crop
        )
        DogumGunuKarti(message,from)
    }


}

@Composable
fun DogumGunuKarti(message: String, from: String) {

    Column {
        Text(
            text = message,
            fontSize = 34.sp,
            modifier = Modifier
                .fillMaxWidth()         // genişliği tüm alanı kapla
                .wrapContentWidth(Alignment.CenterHorizontally) //yazının genişliği kadar sığdır
                                        // Alignment hizala neye göre hizala yataya göre merkezde hizala
        )
        Text(
            text = from,
            fontSize = 18.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(top = 16.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeGirisTheme {
        DogumGunuKarti(message = "Hello Zeynep", from = "-from Hasan")
    }
}