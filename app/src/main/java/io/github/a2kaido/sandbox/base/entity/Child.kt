package io.github.a2kaido.sandbox.base.entity

import io.github.a2kaido.sandbox.domain.model.Gender

data class Child(
    val name: String,
    val gender: Gender,
    val birthYear: Int
)
