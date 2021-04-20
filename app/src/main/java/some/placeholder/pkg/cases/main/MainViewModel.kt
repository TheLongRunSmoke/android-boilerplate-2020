/*
 * Copyright (C) 2020 Alexander Varakosov aka TheLongRunSmoke
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package some.placeholder.pkg.cases.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import pro.tlrs.boilerplate2020.lives.SingleLiveEvent
import some.placeholder.pkg.UserPreferences
import javax.inject.Inject

/**
 * Example view model.
 */
class MainViewModel @Inject constructor(
    val preferences: UserPreferences  // Use injector constructor for viewmodels.
) : ViewModel() {

    /**
     * Back field for state.
     * Use _state.value or _state.pastValue() to set state, sync or async respectively.
     */
    private val _state = SingleLiveEvent<MainActivityState>()

    /**
     * LiveData for states, observe it in view.
     */
    internal val state: LiveData<MainActivityState>
        get() = _state

}