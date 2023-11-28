package com.example.smartHome.supabase.authorization.data.remote

interface AuthenticationRepository {
    suspend fun signIn(email: String, password: String): Boolean
    suspend fun signUp(email: String, password: String, username: String): Boolean
}