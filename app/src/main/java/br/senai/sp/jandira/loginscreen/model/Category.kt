package br.senai.sp.jandira.loginscreen.model

import androidx.compose.ui.graphics.painter.Painter

data class Category(

    val id: Int = 0,
    val name: String = "",
    val image: Painter? = null

)
