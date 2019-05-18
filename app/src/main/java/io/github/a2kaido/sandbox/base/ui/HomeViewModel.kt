package io.github.a2kaido.sandbox.base.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.a2kaido.sandbox.base.repository.ProfileRepository
import io.github.a2kaido.sandbox.domain.model.Profile
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class HomeViewModel(
    private val profileRepository: ProfileRepository
) : ViewModel(), CoroutineScope {

    private val job = SupervisorJob()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    val profile: MutableLiveData<Profile> = MutableLiveData()

    val nextProfile: MutableLiveData<Profile> = MutableLiveData()

    fun next() {
        launch {
            val friends = profileRepository.getFriends()
            profile.value = friends[0]
            nextProfile.value = friends[1]
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancelChildren()
    }
}
