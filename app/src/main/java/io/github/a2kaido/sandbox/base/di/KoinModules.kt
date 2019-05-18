package io.github.a2kaido.sandbox.base.di

import io.github.a2kaido.sandbox.base.repository.ProfileRepository
import io.github.a2kaido.sandbox.base.repository.remote.FriendRemote
import io.github.a2kaido.sandbox.base.ui.HomeViewModel
import io.github.a2kaido.sandbox.base.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val koinModules = module {

    single { FriendRemote() }

    single { ProfileRepository(get()) }

    viewModel { MainViewModel() }

    viewModel { HomeViewModel(get()) }
}