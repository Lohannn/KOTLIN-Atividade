package br.senai.sp.jandira.loginscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.loginscreen.components.BottomShape
import br.senai.sp.jandira.loginscreen.components.TopShape
import br.senai.sp.jandira.loginscreen.ui.theme.LoginScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreenTheme {
                LoginScreen()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreen() {

    var defaultColor = colorResource(id = R.color.default_color)

    var emailState = rememberSaveable {
        mutableStateOf("")
    }

    var passwordState = rememberSaveable {
        mutableStateOf("")
    }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                horizontalArrangement = Arrangement.End
            ) {
                TopShape()
            }
            Spacer(modifier = Modifier.height(160.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(17.dp, 0.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.login_title),
                    fontSize = 48.sp,
                    fontWeight = FontWeight(700),
                    color = defaultColor,
                )
                Text(
                    text = stringResource(id = R.string.login_description),
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                    color = Color(160, 156, 156)
                )
            }
            Spacer(modifier = Modifier.height(87.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = emailState.value,
                    onValueChange = {
                        emailState.value = it
                    },
                    label = { Text(stringResource(id = R.string.email)) },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.baseline_email_24),
                            contentDescription = "E-Mail",
                            tint = defaultColor
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(58.dp),
                    shape = RoundedCornerShape(16.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = passwordState.value,
                    onValueChange = {
                        passwordState.value = it
                    },
                    label = { Text(stringResource(id = R.string.password)) },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.baseline_lock_24),
                            contentDescription = "Password",
                            tint = defaultColor
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(58.dp),
                    shape = RoundedCornerShape(16.dp),
                    visualTransformation = PasswordVisualTransformation()
                )
            }
            Spacer(modifier = Modifier.height(31.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.End
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(defaultColor),
                    modifier = Modifier
                        .width(134.dp)
                        .height(48.dp),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.sign_in).uppercase(),
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(700)
                    )
                    Icon(
                        painter = painterResource(
                            id = R.drawable.baseline_arrow_forward_24
                        ),
                        contentDescription = "Seta",
                        tint = Color.White
                    )
                }
                Row() {
                    Text(
                        text = stringResource(id = R.string.dont_have_account),
                        fontSize = 12.sp,
                        color = Color(160, 156, 156),
                        modifier = Modifier.padding(top = 31.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = stringResource(id = R.string.signup_title),
                        modifier = Modifier
                            .clickable { }
                            .padding(top = 31.dp),
                        fontSize = 12.sp,
                        color = defaultColor,
                        fontWeight = FontWeight(700)
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.Bottom
            ) {
                BottomShape()
            }
        }
    }
}