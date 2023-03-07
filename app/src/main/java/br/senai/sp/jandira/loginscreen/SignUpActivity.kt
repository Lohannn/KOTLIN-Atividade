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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.loginscreen.ui.theme.LoginScreenTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreenTheme {
              SignUpScreen()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpScreen() {
    var defaultColor = colorResource(id = R.color.default_color)

    var usernameState = rememberSaveable {
        mutableStateOf("")
    }

    var phoneState = rememberSaveable {
        mutableStateOf("")
    }

    var emailState = rememberSaveable {
        mutableStateOf("")
    }

    var passwordState = rememberSaveable {
        mutableStateOf("")
    }

    var checkBoxState = false

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
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(120.dp)
                        .background(
                            defaultColor,
                            shape = RoundedCornerShape(
                                bottomStart = 16.dp
                            )
                        )
                )
            }
            Spacer(modifier = Modifier.height(47.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Sign Up",
                    fontSize = 32.sp,
                    fontWeight = FontWeight(700),
                    color = defaultColor,
                )
                Text(
                    text = "Create a new account",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                    color = Color(160, 156, 156)
                )
            }
            Spacer(modifier = Modifier.height(50.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = usernameState.value,
                    onValueChange = {
                        usernameState.value = it
                    },
                    label = { Text("Username") },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.baseline_person_24),
                            contentDescription = "username",
                            tint = defaultColor
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(58.dp),
                    shape = RoundedCornerShape(16.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = phoneState.value,
                    onValueChange = {
                        phoneState.value = it
                    },
                    label = { Text("Phone") },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.baseline_phone_android_24),
                            contentDescription = "Phone",
                            tint = defaultColor
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(58.dp),
                    shape = RoundedCornerShape(16.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = emailState.value,
                    onValueChange = {
                        emailState.value = it
                    },
                    label = { Text("E-mail") },
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
                    label = { Text("Password") },
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
            Spacer(modifier = Modifier.height(21.dp))
            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
                    ) {
                Checkbox(
                    checked = checkBoxState,
                    onCheckedChange =
                )
                Spacer(modifier = Modifier.height(11.dp))
                Text(text = "Over 18?")
            }
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
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(
                        text = "CREATE ACCOUNT",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(700)
                    )
                }
                Row() {
                    Text(
                        text = "Already have an account?",
                        fontSize = 12.sp,
                        color = Color(160, 156, 156),
                        modifier = Modifier.padding(top = 31.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Sign in",
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
                Box(
                    modifier = Modifier
                        .height(40.dp)
                        .width(120.dp)
                        .background(
                            defaultColor,
                            shape = RoundedCornerShape(
                                topEnd = 16.dp
                            )
                        )
                )
            }
        }
    }
}