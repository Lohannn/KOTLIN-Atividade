package br.senai.sp.jandira.loginscreen

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import br.senai.sp.jandira.loginscreen.model.User
import br.senai.sp.jandira.loginscreen.repository.UserRepository
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

    var usernameState by remember {
        mutableStateOf("")
    }

    var phoneState by remember {
        mutableStateOf("")
    }

    var emailState by remember {
        mutableStateOf("")
    }

    var passwordState by remember {
        mutableStateOf("")
    }

    var checkBoxState by remember {
        mutableStateOf(false)
    }

    var context = LocalContext.current

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
        ) {
            //-------------------------------------------------------------------------
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .weight(0.06f),
                horizontalArrangement = Arrangement.End
            ) {
                TopShape()
            }
            //-------------------------------------------------------------------------
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .weight(weight = 1f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(id = R.string.signup_title),
                        fontSize = 32.sp,
                        fontWeight = FontWeight(700),
                        color = defaultColor,
                    )
                    Text(
                        text = stringResource(id = R.string.signup_description),
                        fontSize = 16.sp,
                        fontWeight = FontWeight(400),
                        color = Color(160, 156, 156)
                    )
                }

                Box(modifier = Modifier.size(100.dp)) {
                    Card(
                        modifier = Modifier
                            .size(100.dp)
                            .align(alignment = Alignment.TopEnd),
                        shape = CircleShape,
                        border = BorderStroke(
                            width = 1.2.dp,
                            Brush.horizontalGradient(colors = listOf(defaultColor, Color.White))
                        )
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_person_outline_24),
                            contentDescription = "",
                            tint = defaultColor
                        )
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.adicionar_foto),
                        contentDescription = "",
                        modifier = Modifier
                            .size(28.dp)
                            .align(Alignment.BottomEnd),
                        tint = defaultColor
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedTextField(
                        value = usernameState,
                        onValueChange = {
                            usernameState = it
                        },
                        label = { Text(stringResource(id = R.string.username)) },
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
                        value = phoneState,
                        onValueChange = {
                            phoneState = it
                        },
                        label = { Text(stringResource(id = R.string.phone)) },
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
                        visualTransformation = PasswordVisualTransformation()
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = checkBoxState,
                        onCheckedChange = { checkBoxState = it },
                        colors = CheckboxDefaults.colors(checkedColor = defaultColor)
                    )
                    Spacer(modifier = Modifier.height(11.dp))
                    Text(text = stringResource(id = R.string.over_eighteen))
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    Button(
                        onClick = {
                            userSave(
                                context,
                                emailState,
                                usernameState,
                                phoneState,
                                passwordState,
                                checkBoxState
                            )
                        },
                        colors = ButtonDefaults.buttonColors(defaultColor),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.create_account),
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight(700)
                        )
                    }
                    Row() {
                        Text(
                            text = stringResource(id = R.string.already_have_account),
                            fontSize = 12.sp,
                            color = Color(160, 156, 156),
                            modifier = Modifier.padding(top = 31.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = stringResource(id = R.string.sign_in),
                            modifier = Modifier
                                .clickable { }
                                .padding(top = 31.dp),
                            fontSize = 12.sp,
                            color = defaultColor,
                            fontWeight = FontWeight(700)
                        )
                    }
                }
            }
            //-------------------------------------------------------------------------
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .weight(0.06f),
                verticalAlignment = Alignment.Bottom
            ) {
                BottomShape()
            }
            //-------------------------------------------------------------------------
        }
    }
}

fun userSave(
    context: Context,
    email: String,
    name: String,
    phone: String,
    password: String,
    isOver: Boolean
) {
    val userRepository = UserRepository(context)
    var user = userRepository.findUserByEmail(email)

    if (user == null) {
        val newUser = User(
            username = name,
            phone = phone,
            email = email,
            password = password,
            isOver18 = isOver
        )
        val id = userRepository.save(newUser)
        Toast.makeText(context, "User created #$id", Toast.LENGTH_LONG).show()
    } else {

    }
}
