package br.senai.sp.jandira.loginscreen.repository

import android.content.Context
import br.senai.sp.jandira.loginscreen.dao.TripDb
import br.senai.sp.jandira.loginscreen.model.User

class UserRepository(context: Context) {

    private val db = TripDb.getDatabase(context)

    fun save(user: User): Long {
        return db.UserDao().save(user)
    }

}