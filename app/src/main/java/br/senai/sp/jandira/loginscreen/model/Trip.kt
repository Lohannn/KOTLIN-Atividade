package br.senai.sp.jandira.loginscreen.model

import androidx.compose.ui.graphics.painter.Painter

data class Trip(

    val id: Long = 0,
    val name: String = "",
    val image: Painter? = null,
    val year: Int = 0,
    val description: String = "",
    val dayOut: String = "",
    val dayBack: String = ""

)
