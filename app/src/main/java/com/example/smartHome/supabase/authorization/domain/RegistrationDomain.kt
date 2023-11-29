package com.example.smartHome.supabase.authorization.domain

import java.util.UUID

data class RegistrationDomain(
    val userId: UUID?,
    val username: String,
    val profileImage: String?,
    val addressId: UUID?,
)