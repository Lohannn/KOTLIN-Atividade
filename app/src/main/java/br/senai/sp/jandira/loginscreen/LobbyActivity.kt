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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.loginscreen.dao.repository.CategoryRepository
import br.senai.sp.jandira.loginscreen.model.Category
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

@Composable
fun LobbyScreenCreator(categories: List<Category>) {

    var defaultColor = colorResource(id = R.color.default_color)

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
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_location_on_24),
                                contentDescription = "",
                                modifier = Modifier.size(20.dp),
                                tint = Color.White
                            )
                            Text(
                                text = "You're in Paris",
                                color = Color.White,
                                fontSize = 14.sp
                            )
                        }
                        Text(
                            text = "My Trips",
                            color = Color.White,
                            fontSize = 24.sp,
                            fontWeight = FontWeight(700),
                            textAlign = TextAlign.Right,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = stringResource(id = R.string.categories),
                modifier = Modifier.padding(bottom = 7.dp),
                color = Color(86, 84, 84, 255)
                )
                LazyRow() {
                    items(categories) { category ->
                        Column(
                            modifier = Modifier
                                .height(64.dp)
                                .width(109.dp)
                                .background(
                                    defaultColor,
                                    shape = RoundedCornerShape(8.dp)
                                ),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            category.image?.let {
                                Icon(
                                    painter = it,
                                    contentDescription = "",
                                    tint = Color.White,
                                    modifier = Modifier.size(32.dp)
                                )
                            }
                            Text(text = category.name, color = Color.White, fontSize = 14.sp)
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                    }
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

@Preview(showBackground = true)
@Composable
fun LobbyScreen() {
    LobbyScreenCreator(CategoryRepository.getCategoryList())
}