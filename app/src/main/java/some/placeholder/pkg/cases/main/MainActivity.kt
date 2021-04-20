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

import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import pro.tlrs.boilerplate2020.views.SelfInjectActivity
import some.placeholder.pkg.R
import some.placeholder.pkg.databinding.ActivityMainBinding

/**
 * Main activity of your application.
 */
class MainActivity : SelfInjectActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    private lateinit var binding: ActivityMainBinding

    // Creating viewmodel instance delegated to viewModels()
    // viewModelFactory available from parent.
    private val viewModel: MainViewModel by viewModels {
        viewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Create lifecycle-aware view bindings.
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Prepare action bar.
        setSupportActionBar(binding.navLayer.toolbar)
        // Setup in-app navigation.
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.nav_home, R.id.nav_example), // Use hamburger icon for this destinations.
            binding.drawerLayout
        )
        val navigationController = getNavController()
        // Setup action bar and drawer with in-app navigation.
        NavigationUI.setupActionBarWithNavController(
            this,
            navigationController,
            appBarConfiguration
        )
        // Setup menu in drawer.
        binding.navDrawerView.setupWithNavController(navigationController)
        // Setup menu in bottom navigation.
        binding.navLayer.bottomNav.setupWithNavController(navigationController)
        // Observe event based state.
        viewModel.state.observe(this, { newState ->
            when (newState) {
                is MainActivityState -> {
                }
                else -> {
                }
            }
        })
    }

    /**
     * Retrieve navigation controller from FragmentContainerView used as navigation host.
     */
    private fun getNavController(): NavController {
        val navHostFragment = supportFragmentManager
            .findFragmentById(binding.navLayer.content.navHost.id) as NavHostFragment
        return navHostFragment.navController
    }

    /**
     * Check for back navigation mode in action bar.
     */
    override fun onSupportNavigateUp(): Boolean {
        return getNavController().navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


}
