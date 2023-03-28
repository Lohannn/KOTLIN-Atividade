package br.senai.sp.jandira.loginscreen.dao.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.loginscreen.R
import br.senai.sp.jandira.loginscreen.model.Category

class CategoryRepository {

    companion object {
        @Composable
        fun getCategoryList(): List<Category> {
            return listOf<Category>(
                Category(
                    1,
                    "Mountain",
                    image = painterResource(id = R.drawable.mountain)
                ),
                Category(
                    2,
                    "Snow",
                    image = painterResource(id = R.drawable.snow)
                ),
                Category(
                    3,
                    "Beach",
                    image = painterResource(id = R.drawable.beach)
                ),
            )
        }
    }

}