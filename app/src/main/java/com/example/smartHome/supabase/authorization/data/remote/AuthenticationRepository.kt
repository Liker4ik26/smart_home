package com.example.smartHome.supabase.authorization.data.remote

import io.github.jan.supabase.gotrue.providers.builtin.Email
import kotlinx.serialization.json.JsonElement

interface AuthenticationRepository {
    suspend fun signIn(email: String, password: String): Boolean
    suspend fun signUp(email: String, password: String): Email.Result?
    suspend fun addUser(username: String): Boolean
}