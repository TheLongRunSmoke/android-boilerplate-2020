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

package some.placeholder.pkg.cases.preferences

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.PreferenceFragmentCompat
import com.google.android.material.snackbar.Snackbar
import some.placeholder.pkg.R

/**
 * Example preferences fragment.
 */
class PreferencesFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        // Inflate screen from XML.
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
        // Let this fragment to place option menu to app bar.
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        // Create option menu.
        inflater.inflate(R.menu.preferences_options, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    /**
     * Handle option menu taps.
     * In this case, we need to handle home button too.
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            // Process back navigation from a toolbar.
            android.R.id.home -> {
                activity?.onBackPressed()
                return true
            }
            R.id.action_about -> {
                Snackbar.make(view ?: return true, "about", Snackbar.LENGTH_SHORT).show()
            }
        }
        return true
    }
}