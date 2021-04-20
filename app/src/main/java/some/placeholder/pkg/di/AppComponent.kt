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

package some.placeholder.pkg.di

import android.content.Context
import androidx.lifecycle.ViewModel
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import some.placeholder.pkg.Application
import some.placeholder.pkg.cases.main.MainActivity
import javax.inject.Provider
import javax.inject.Singleton

/**
 * Application module.
 * Handle android specified injection and viewmodel injection.
 */
@Component(modules = [AndroidInjectionModule::class, ViewModelModule::class, AppModule::class, UiModule::class])
@Singleton
interface AppComponent : AndroidInjector<Application> {

    /**
     * Container for viewmodel providers, that will be used by dagger multibinding.
     */
    fun getViewModels(): Map<Class<out ViewModel>, Provider<ViewModel>>

    // Let application module handle main activity injection, to make it simple.
    fun inject(mainActivity: MainActivity)

    // Component builder, see Dagger docs for details.
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun appContext(context: Context): Builder
        fun build(): AppComponent
    }

}