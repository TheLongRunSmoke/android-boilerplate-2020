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
import some.placeholder.pkg.cases.home.di.DaggerHomeComponent
import some.placeholder.pkg.cases.home.di.HomeComponent
import java.util.concurrent.ConcurrentHashMap

/**
 * Dagger components manager.
 *
 * Using:
 *  in Application class:
 *      ...
 *      ComponentManager.initAppComponent(applicationContext)
 *      ...
 *
 *  To add new component support in ComponentManager.createComponent():
 *      ...
 *       SomeComponent::class.java -> {
 *          DaggerSomeComponent.builder()
 *              .appComponent(appComponent)
 *              .someModule(SomeModule())
 *              .build()
 *       }
 *      ...
 *
 *  To create component:
 *      ...
 *      ComponentManager.getComponent(SomeComponent::class.java)
 *      ...
 *  To clear component:
 *      ...
 *      ComponentManager.clearComponent(SomeComponent::class.java)
 *      ...
 */
object ComponentManager {

    private lateinit var appComponent: AppComponent

    private var subComponents: ConcurrentHashMap<Class<out Any>, Any> = ConcurrentHashMap()

    /**
     * Initialize application component.
     *
     * @param context application context.
     */
    @Synchronized
    fun initAppComponent(context: Context): AppComponent {
        if (!this::appComponent.isInitialized) {
            appComponent = DaggerAppComponent
                .builder()
                .appContext(context)
                .build()
        }
        return appComponent
    }

    /**
     * Retrieve component from store.
     *
     * Create if not exist.
     *
     * @param clazz as java class.
     */
    @Synchronized
    fun <T : Any> getComponent(clazz: Class<T>): T {
        // Trying to get component instance.
        var instance = subComponents[clazz]
        // If nothing found, instantiate and place to map.
        if (instance == null) {
            instance = createComponent(clazz)
            subComponents[clazz] = instance
        }
        // Type used as key, so cast is always safe.
        @Suppress("UNCHECKED_CAST")
        return instance as T
    }

    /**
     * Clear component when not needed anymore.
     *
     * @param clazz as java class.
     */
    @Synchronized
    fun clearComponent(clazz: Class<out Any>) {
        subComponents.remove(clazz)
    }

    /**
     * Create component of given type.
     *
     *  @param clazz as java class.
     */
    private fun <T : Any> createComponent(clazz: Class<T>): Any {
        return when (clazz) {
            HomeComponent::class.java -> {
                DaggerHomeComponent.builder()
                    .appComponent(appComponent)
                    .build()
            }
            else -> {
                throw IllegalArgumentException("Unknown component class $clazz. See ComponentManager for additional information.")
            }
        }
    }


}