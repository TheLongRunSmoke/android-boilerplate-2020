package pro.tlrs.boilerplate2020.lifecycle

import androidx.lifecycle.LiveData
import pro.tlrs.boilerplate2020.lives.SingleLiveEvent

/**
 * Viewmodel parametrized by state class or superclass.
 */
open class ViewModel<STATE> : androidx.lifecycle.ViewModel() {
    /**
     * Back field for state.
     * Use _state.value or _state.pastValue() to set state, sync or async respectively.
     */
    private val _state = SingleLiveEvent<STATE>()

    /**
     * LiveData for states, observe it in view.
     */
    val state: LiveData<STATE>
        get() = _state
}