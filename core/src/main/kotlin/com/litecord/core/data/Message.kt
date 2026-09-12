package com.litecord.core.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "messages",
    foreignKeys = [
        ForeignKey(entity = User::class, parentColumns = ["id"], childColumns = ["senderId"])
    ]
)
data class Message(
    @PrimaryKey val id: String,
    val senderId: String,
    val content: String,
    val channelId: String,
    val timestamp: Long = System.currentTimeMillis(),
    val edited: Boolean = false,
    val editedAt: Long? = null
)
