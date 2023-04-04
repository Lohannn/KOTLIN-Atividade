package br.senai.sp.jandira.loginscreen.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import br.senai.sp.jandira.loginscreen.R
import br.senai.sp.jandira.loginscreen.model.Category
import br.senai.sp.jandira.loginscreen.model.Trip

class TripRepository {

    companion object {
        @Composable
        fun getTripList(): List<Trip> {
            return listOf<Trip>(
                Trip(
                    id = 1,
                    name = "London",
                    image = painterResource(id = R.drawable.london),
                    year = 2019,
                    description = "London is the capital and largest city of  the United Kingdom, with a population of just under 9 million.",
                    dayOut = "18 Feb",
                    dayBack = "21 Feb"
                ),
                Trip(
                    id = 2,
                    name = "Porto",
                    image = painterResource(id = R.drawable.porto),
                    year = 2022,
                    description = "Porto is the second city in Portugal, the capital of the Oporto District, and one of the Iberian Peninsula's major urban areas.",
                    dayOut = "15 May",
                    dayBack = "22 May"
                )
            )
        }
    }

}