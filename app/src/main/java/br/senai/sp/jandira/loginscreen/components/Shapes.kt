package br.senai.sp.jandira.loginscreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.loginscreen.R

@Composable
fun TopShape(){
    Box(
        modifier = Modifier
            .height(40.dp)
            .width(120.dp)
            .background(
                colorResource(id = R.color.default_color),
                shape = RoundedCornerShape(
                    bottomStart = 16.dp
                )
            )
    )
}

@Preview
@Composable
fun TopShapePreview() {
    TopShape()
}

@Composable
fun BottomShape() {
    Box(
        modifier = Modifier
            .height(40.dp)
            .width(120.dp)
            .background(
                colorResource(id = R.color.default_color),
                shape = RoundedCornerShape(
                    topEnd = 16.dp
                )
            )
    )
}

@Preview
@Composable
fun BottomShapePreview() {
    BottomShape()
}