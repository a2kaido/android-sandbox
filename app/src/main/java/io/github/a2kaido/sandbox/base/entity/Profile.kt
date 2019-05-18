package io.github.a2kaido.sandbox.base.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Profile(
    @PrimaryKey
    val id: Long,
    val name: String,
    val children: List<Child>
)
