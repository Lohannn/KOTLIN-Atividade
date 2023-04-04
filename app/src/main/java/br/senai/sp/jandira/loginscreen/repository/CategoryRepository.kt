package br.senai.sp.jandira.loginscreen.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import br.senai.sp.jandira.loginscreen.R
import br.senai.sp.jandira.loginscreen.model.Category

class CategoryRepository {

    companion object {
        @Composable
        fun getCategoryList(): List<Category> {
            return listOf<Category>(
                Category(
                    1,
                    stringResource(id = R.string.mountain_category),
                    image = painterResource(id = R.drawable.mountain)
                ),
                Category(
                    2,
                    stringResource(id = R.string.snow_category),
                    image = painterResource(id = R.drawable.snow)
                ),
                Category(
                    3,
                    stringResource(id = R.string.beach_category),
                    image = painterResource(id = R.drawable.beach)
                )
            )
        }
    }

}