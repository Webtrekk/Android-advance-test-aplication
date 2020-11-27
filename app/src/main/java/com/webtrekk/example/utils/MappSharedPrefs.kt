/*
 *  MIT License
 *
 *  Copyright (c) 2019 Webtrekk GmbH
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 *
 */

package com.webtrekk.example.utils

import android.content.Context
import android.content.SharedPreferences

/**
 * A class that manages all of Webtrekk internal SharedPreferences. This class can be used only for internal saving
 */
class MappSharedPrefs(context: Context) {

    val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    var trackingId: String
        inline get() = sharedPreferences.getString(TRACKING_ID, "658572554704007") ?: "658572554704007"
        set(value) = sharedPreferences.edit().putString(TRACKING_ID, value).apply()

    var trackingDomain: String
        inline get() = sharedPreferences.getString(TRACKING_DOMAIN, "https://webtrekkdemoapp01.wt-eu02.net") ?: "https://webtrekkdemoapp01.wt-eu02.net"
        set(value) = sharedPreferences.edit().putString(TRACKING_DOMAIN, value).apply()

    fun contains(key: String): Boolean = sharedPreferences.contains(key)

    companion object {

        const val SHARED_PREFS_NAME = "mapp-intelligence-pref"
        const val TRACKING_ID = "trackingId"
        const val TRACKING_DOMAIN = "trackingDomain"

    }
}
