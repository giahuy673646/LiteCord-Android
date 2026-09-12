package com.litecord.network

import com.litecord.core.data.Message
import com.litecord.core.data.User
import retrofit2.http.*

interface LiteCordApi {

    // Auth endpoints
    @POST("auth/register")
    suspend fun register(@Body user: User): ApiResponse<AuthToken>

    @POST("auth/login")
    suspend fun login(@Body credentials: LoginRequest): ApiResponse<AuthToken>

    // User endpoints
    @GET("users/{id}")
    suspend fun getUser(@Path("id") userId: String): ApiResponse<User>

    @PUT("users/{id}")
    suspend fun updateUser(@Path("id") userId: String, @Body user: User): ApiResponse<User>

    // Messages
    @GET("channels/{id}/messages")
    suspend fun getMessages(@Path("id") channelId: String): ApiResponse<List<Message>>

    @POST("channels/{id}/messages")
    suspend fun sendMessage(
        @Path("id") channelId: String,
        @Body message: Message
    ): ApiResponse<Message>

    @DELETE("messages/{id}")
    suspend fun deleteMessage(@Path("id") messageId: String): ApiResponse<Unit>
}

data class ApiResponse<T>(
    val success: Boolean,
    val data: T?,
    val error: String?
)

data class AuthToken(
    val token: String,
    val expiresIn: Long
)

data class LoginRequest(
    val email: String,
    val password: String
)
