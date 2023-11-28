package com.example.smartHome.supabase.authorization.domain

data class RegistrationDomain(
    val password: String,
    val profileImage: String,
    val username: String,
    val email: String,
    val userId: Int,
    val homeAddressId: Int,
)