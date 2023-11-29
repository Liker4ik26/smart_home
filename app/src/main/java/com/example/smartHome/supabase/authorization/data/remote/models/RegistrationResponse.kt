package com.example.smartHome.supabase.authorization.data.remote.models

import io.github.jan.supabase.gotrue.user.UserInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class RegistrationResponse(

    @SerialName("id")
    val userId: String,

    @SerialName("username")
    val username: String,

    @SerialName("profile_image")
    val profileImage: String,

    @SerialName("address_id")
    val addressId: String,
)