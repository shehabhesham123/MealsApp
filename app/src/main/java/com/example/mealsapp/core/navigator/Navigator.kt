package com.example.mealsapp.core.navigator

import android.content.Context
import android.content.Intent
import com.example.mealsapp.features.meals.app.ui.MainActivity
import com.example.mealsapp.features.auth.credentials.Authenticator
import javax.inject.Inject

class Navigator @Inject constructor(private val authenticator: Authenticator) {
    fun showMain(context: Context) {
        if (authenticator.isLogin()) {
            context.startActivity(Intent(context, MainActivity::class.java))
        } else {
            // go to login activity
        }
    }
}