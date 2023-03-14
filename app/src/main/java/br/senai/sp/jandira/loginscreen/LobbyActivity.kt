package br.senai.sp.jandira.loginscreen

import android.graphics.SurfaceTexture
import android.os.Bundle
import android.view.SurfaceView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
            Surface(
                modifier = Modifier
                    .height(197.dp)
                    .fillMaxWidth(),
            ) {
                //Image(painter = painterResource(id = R.drawable.paris),
                    //contentDescription = "")
                Column() {
                    Row() {

                    }
                    Row() {

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