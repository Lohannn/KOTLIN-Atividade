package br.senai.sp.jandira.loginscreen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.loginscreen.components.BottomShape
import br.senai.sp.jandira.loginscreen.components.TopShape
import br.senai.sp.jandira.loginscreen.repository.UserRepository
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

    var emailState by remember {
        mutableStateOf("")
    }

    var passwordState by remember {
        mutableStateOf("")
    }

    var passVisibilityState by remember {
        mutableStateOf(true)
    }

    val context = LocalContext.current

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
                    value = emailState,
                    onValueChange = {
                        emailState = it
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
                    value = passwordState,
                    onValueChange = {
                        passwordState = it
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
                    visualTransformation = if (passVisibilityState)
                        PasswordVisualTransformation()
                    else
                        VisualTransformation.None,
                    trailingIcon = {
                        IconButton(onClick = {
                            passVisibilityState = !passVisibilityState
                        }) {
                            Icon(
                                imageVector = if (passVisibilityState)
                                    Icons.Default.Visibility
                                else
                                    Icons.Default.VisibilityOff,
                                contentDescription = "show"
                            )
                        }
                    }
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
                    onClick = {
                        authenticate(emailState, passwordState, context)
                    },
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
                            .clickable(
                                onClick = {
                                    var openSignup = Intent(context, SignUpActivity::class.java)
                                    context.startActivity(openSignup)
                                }
                            )
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

fun authenticate(email: String, password: String, context: Context) {
    val userRepository = UserRepository(context)
    val user = userRepository.authenticate(email, password)

    if (user != null) {
        val openHome = Intent(context, LobbyActivity::class.java)
        context.startActivity(openHome)
    } else {
        Toast.makeText(context, "Wrong Email or Password", Toast.LENGTH_LONG).show()
    }
}
