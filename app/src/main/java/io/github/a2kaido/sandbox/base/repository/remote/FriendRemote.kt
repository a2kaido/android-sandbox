package io.github.a2kaido.sandbox.base.repository.remote

import io.github.a2kaido.sandbox.domain.model.Gender
import io.github.a2kaido.sandbox.domain.model.Profile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FriendRemote {

    suspend fun getFriends() = withContext(Dispatchers.IO) {
        listOf(
            Profile("Joe", Gender.FEMALE, ""),
            Profile("Mary", Gender.FEMALE, ""),
            Profile("George", Gender.FEMALE, "")
        )
    }
}
