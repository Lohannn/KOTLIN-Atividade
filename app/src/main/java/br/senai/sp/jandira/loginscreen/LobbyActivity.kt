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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.loginscreen.repository.CategoryRepository
import br.senai.sp.jandira.loginscreen.repository.TripRepository
import br.senai.sp.jandira.loginscreen.model.Category
import br.senai.sp.jandira.loginscreen.model.Trip
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
fun LobbyScreenCreator(categories: List<Category>, trips: List<Trip>) {

    var defaultColor = colorResource(id = R.color.default_color)

    var destinity = rememberSaveable {
        mutableStateOf("")
    }
    
    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = { /*TODO*/ }) {
            Text(text = "+")
        }
    }) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(248, 248, 248, 255)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(
                    modifier = Modifier
                        .height(197.dp)
                        .fillMaxWidth(),
                    elevation = 4.dp,
                    shape = RectangleShape
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
                        Column(
                            modifier = Modifier.width(300.dp),
                            horizontalAlignment = Alignment.Start
                        ) {
                            Row() {
                                Icon(
                                    painter = painterResource(id = R.drawable.baseline_location_on_24),
                                    contentDescription = "",
                                    modifier = Modifier.size(20.dp),
                                    tint = Color.White
                                )
                                Text(
                                    text = stringResource(id = R.string.you_are_in) + " Paris",
                                    color = Color.White,
                                    fontSize = 14.sp
                                )
                            }
                            Text(
                                text = stringResource(id = R.string.my_trips),
                                color = Color.White,
                                fontSize = 24.sp,
                                fontWeight = FontWeight(700),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 18.dp)
                            )
                        }
                    }
                }
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = stringResource(id = R.string.categories),
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
                OutlinedTextField(modifier = Modifier
                    .width(350.dp)
                    .height(52.5.dp)
                    .border(border = BorderStroke(color = Color.Transparent, width = 0.dp)),
                    value = destinity.value,
                    onValueChange = {
                        destinity.value = it
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(16.dp),
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.search_destinity),
                            color = Color(183, 183, 183, 255)
                        )
                    },
                    trailingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.baseline_search_24),
                            contentDescription = "Search",
                            tint = Color(183, 183, 183, 255)
                        )
                    })
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = stringResource(id = R.string.past_trips),
                        color = Color(86, 84, 84, 255)
                    )
                    Spacer(modifier = Modifier.height(9.dp))
                    LazyColumn(modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        content = {
                            items(trips) { trip ->
                                Surface(
                                    modifier = Modifier
                                        .height(208.dp)
                                        .fillMaxWidth(),
                                    shape = RoundedCornerShape(8.dp),
                                    color = Color.White,
                                    elevation = 3.dp
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(5.dp),
                                        verticalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Card(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(106.dp)
                                        ) {
                                            trip.image?.let {
                                                Image(
                                                    painter = it,
                                                    contentDescription = "",
                                                    contentScale = ContentScale.Crop
                                                )
                                            }
                                        }
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.Start
                                        ) {
                                            Text(
                                                text = trip.name,
                                                color = defaultColor
                                            )
                                            Text(
                                                text = ", ",
                                                color = defaultColor
                                            )
                                            Text(
                                                text = trip.year.toString(),
                                                color = defaultColor
                                            )
                                        }
                                        Text(
                                            text = trip.description,
                                            color = Color(160, 156, 156, 255),
                                            fontSize = 10.sp
                                        )
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.End
                                        ) {
                                            Text(
                                                text = trip.dayOut,
                                                color = defaultColor,
                                                fontSize = 10.sp
                                            )
                                            Text(
                                                text = " - ",
                                                color = defaultColor,
                                                fontSize = 10.sp
                                            )
                                            Text(
                                                text = trip.dayBack,
                                                color = defaultColor,
                                                fontSize = 10.sp
                                            )
                                        }
                                    }
                                }
                                Spacer(modifier = Modifier.height(11.dp))
                            }
                        })
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LobbyScreen() {
    LobbyScreenCreator(CategoryRepository.getCategoryList(), TripRepository.getTripList())
}