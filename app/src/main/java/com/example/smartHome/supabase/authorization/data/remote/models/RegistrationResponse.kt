package com.example.smartHome.supabase.authorization.data.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegistrationResponse(

    @SerialName("password")
    val password: String,

    @SerialName("profile_image")
    val profileImage: String,

    @SerialName("username")
    val username: String,

    @SerialName("email")
    val email: String,

    @SerialName("user_id")
    val userId: Int,

    @SerialName("home_address_id")
    val homeAddressId: Int,
)