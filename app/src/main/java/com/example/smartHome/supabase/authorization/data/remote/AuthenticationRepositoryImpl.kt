package com.example.smartHome.supabase.authorization.data.remote

import android.util.Log
import com.example.smartHome.supabase.authorization.data.remote.models.RegistrationResponse
import io.github.jan.supabase.gotrue.GoTrue
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.query.Returning
import javax.inject.Inject

class AuthenticationRepositoryImpl @Inject constructor(
    private val postgrest: Postgrest,
    private val goTrue: GoTrue
) : AuthenticationRepository {
    override suspend fun signIn(email: String, password: String): Boolean {
        return try {
            goTrue.loginWith(Email) {
                this.email = email
                this.password = password
            }
            true
        } catch (e: Exception) {
            Log.e(e.message, e.stackTraceToString())
            false
        }
    }

    override suspend fun signUp(
        email: String,
        password: String,
    ): Email.Result? {
        return try {
            goTrue.signUpWith(Email) {
                this.email = email
                this.password = password
            }
        } catch (e: Exception) {
            Log.e(e.message, e.stackTraceToString())
            null
        }
    }

    override suspend fun addUser(username: String): Boolean {
        try {
            val result =
            postgrest.from("users")
                .insert(
                    value =
                    mapOf(
                        "id" to goTrue.currentUserOrNull()!!.id,
                        "username" to username,
                    ),
                    returning = Returning.MINIMAL,
                    upsert = true
                )
            Log.d(
                "res", result.body.toString()
            )
            return true
        } catch (e: Exception) {
            Log.e("resEa", e.stackTraceToString())
            return false
        }
    }
}