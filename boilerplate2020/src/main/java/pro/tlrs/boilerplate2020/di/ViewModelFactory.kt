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

package pro.tlrs.boilerplate2020.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

/**
 * ViewModel factory.
 *
 * Create ViewModel instances using injection provider.
 * Provider creation and storage delegated to Dagger multibinding.
 *
 * How to use:
 *
 * 1) Add factory to module:
 * {@code
 *  @Binds
 *  abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
 * }
 *
 * 2) For new ViewModel add binder to module:
 * {@code
 *  @Binds
 *  @IntoMap
 *  @ViewModelKey(SomeViewModel::class)
 *  abstract fun bindSomeViewModel(viewModel: SomeViewModel): ViewModel
 * }
 */
class ViewModelFactory @Inject constructor(
    private val providers: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {
    /**
     * Instantiate ViewModel based on its type.
     *
     * @param modelClass ViewModel type to create
     * @return ViewModel instance
     */
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // Get injection provider from container, if appropriate class not found, select by ancestor type.
        val provider = providers[modelClass] ?: providers.entries.firstOrNull {
            modelClass.isAssignableFrom(it.key)
        }?.value
        // Nothing found? Throw developing exception.
        ?: throw IllegalArgumentException("Unknown model class $modelClass. See ViewModelFactory for additional information.")
        // Provider parametrized with base class, so cast is always safe.
        @Suppress("UNCHECKED_CAST")
        return provider.get() as T
    }
}