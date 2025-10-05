package com.example.gallery

import android.icu.number.Scale
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.gallery.ui.theme.GalleryTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                    Greeting()
                }
            }
        }



@Composable
fun Greeting(modifier: Modifier = Modifier) {

    var image by remember { mutableStateOf(1) }
    var imageResource =when(image){
        1 -> R.drawable.wp1
        2 -> R.drawable.wp2
        else -> R.drawable.wp3
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = null,
            modifier = modifier.padding(24.dp).size(300.dp),
            contentScale = ContentScale.Crop)


        Row {
            Text(
                text = "Wallpapers",
                fontSize = 24.sp


            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row {

            Button({ image -= 1 }) {
                Text(text = "Previous")
            }
            Spacer(modifier = Modifier.width(128.dp))
            Button({ image += 1 }) {
                Text(text = "Next")
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

        Greeting()

}