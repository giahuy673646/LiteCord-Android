package com.litecord.core.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey val id: String,
    val username: String,
    val email: String,
    val avatar: String? = null,
    val status: String = "offline",
    val bio: String? = null,
    val createdAt: Long = System.currentTimeMillis()
)
