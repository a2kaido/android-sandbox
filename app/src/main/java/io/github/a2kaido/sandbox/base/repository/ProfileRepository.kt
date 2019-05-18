package io.github.a2kaido.sandbox.base.repository

import io.github.a2kaido.sandbox.base.repository.remote.FriendRemote

class ProfileRepository(
    private val friendRemote: FriendRemote
) {

    suspend fun getFriends() = friendRemote.getFriends()
}