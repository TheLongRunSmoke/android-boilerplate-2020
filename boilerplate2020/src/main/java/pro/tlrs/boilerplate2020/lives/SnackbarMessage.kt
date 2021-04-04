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

package pro.tlrs.boilerplate2020.lives

import androidx.lifecycle.LifecycleOwner


class SnackbarMessage : SingleLiveEvent<SnackbarMessage.Message>() {

    fun observe(owner: LifecycleOwner, observer: SnackbarObserver) {
        super.observe(owner,
            {
                when (it) {
                    is Ok -> {
                        observer.onOkMessage(it.message)
                    }
                    is Info -> {
                        observer.onInfoMessage(it.message)
                    }
                    is Error -> {
                        observer.onErrorMessage(it.message)
                    }
                    else -> {
                    }
                }
            })
    }

    sealed class Message(val message: String)
    sealed class Ok
    sealed class Info
    sealed class Error

    interface SnackbarObserver {
        fun onOkMessage(message: String)
        fun onInfoMessage(message: String)
        fun onErrorMessage(message: String)
    }
}