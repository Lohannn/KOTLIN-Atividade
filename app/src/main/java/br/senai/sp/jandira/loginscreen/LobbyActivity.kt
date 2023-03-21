package br.senai.sp.jandira.loginscreen

import android.graphics.SurfaceTexture
import android.os.Bundle
import android.view.SurfaceView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.loginscreen.ui.theme.LoginScreenTheme

class LobbyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreenTheme {
                LobbyScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LobbyScreen() {

    var surfaceTexture = SurfaceTexture(R.drawable.paris)

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Card(
                modifier = Modifier
                    .height(197.dp)
                    .fillMaxWidth(),
                elevation = 4.dp
            ) {
                Image(
                    painter = painterResource(id = R.drawable.paris),
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds
                )
                Column(
                    modifier = Modifier.padding(
                        top = 13.dp,
                        bottom = 13.dp,
                        start = 19.dp,
                        end = 19.dp
                    ),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.End
                    ) {
                        Card(
                            modifier = Modifier.size(61.dp),
                            shape = CircleShape
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.user),
                                contentDescription = ""
                            )
                        }
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            text = "Susanna Hoffs",
                            color = Color.White,
                            fontWeight = FontWeight(700),
                            fontSize = 12.sp,
                            textAlign = TextAlign.Right
                        )
                    }
                    Column(modifier = Modifier.width(116.dp)) {
                        Row() {
                            Icon(painter = painterResource(id = R.drawable.baseline_location_on_24),
                            contentDescription = "",
                            modifier = Modifier.size(20.dp),
                            tint = Color.White)
                            Text(text = "You're in Paris",
                            color = Color.White,
                            fontSize = 14.sp)
                        }
                        Text(text = "My Trips",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight(700),
                        textAlign = TextAlign.Right,
                        modifier = Modifier.fillMaxWidth())
                    }
                }
            }
            Column() {
                Text(text = "")
                Row() {
                    Column() {

                    }
                    Column() {

                    }
                    Column() {

                    }
                }
                OutlinedTextField(value = "", onValueChange = {})
            }
            Column() {
                Text(text = "")
                Column() {

                }
            }
        }
    }
}