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

package pro.tlrs.boilerplate2020

import android.app.Activity
import android.app.DownloadManager
import android.content.Context
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.annotation.ColorRes
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.navigation.NavigationView

/**
 * Useful extensions.
 */

/**
 * Check everything for null.
 * Just make any code more kotlin-look.
 */
fun Any?.isNull() = this == null

/**
 *  Tag field.
 */
inline val <reified T> T.TAG
    get() = T::class.java.simpleName

/**
 * Get color via compat library.
 */
fun Context.getCompatColor(@ColorRes resId: Int) = ContextCompat.getColor(this, resId)

/**
 * System services as fields.
 */
val Context.windowManager
    get() = getSystemService(Context.WINDOW_SERVICE) as WindowManager

val Context.connectivityManager
    get() = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

val Context.inputMethodManager
    get() = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

val Context.downloadManager
    get() = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

/**
 * Hide keyboard.
 *
 * If keyboard do not hide when focus returned to activity check for stateAlwaysHidden flag in windowSoftInputMode in manifest.
 */
fun View?.hideKeyboard() {
    this?.let {
        val imm = it.context.inputMethodManager
        imm.hideSoftInputFromWindow(it.rootView.windowToken, 0)
    }
}

/**
 * Get rid of this ugly permission check.
 */
fun Activity.hasPermission(permission: String): Boolean {
    return ActivityCompat.checkSelfPermission(
        this,
        permission
    ) == PackageManager.PERMISSION_GRANTED
}
