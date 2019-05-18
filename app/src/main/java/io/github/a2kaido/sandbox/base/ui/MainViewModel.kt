package io.github.a2kaido.sandbox.base.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    enum class ViewType {
        WALK_THROUGH, HOME
    }

    private val _viewType = MutableLiveData<ViewType>().apply { value = ViewType.WALK_THROUGH }
    val viewType: LiveData<ViewType>
        get() = _viewType
}
