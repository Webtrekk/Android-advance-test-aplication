package com.example.android_advance_test_aplication

import android.app.Application
import androidx.work.Constraints
import androidx.work.NetworkType
import webtrekk.android.sdk.Logger
import webtrekk.android.sdk.Webtrekk
import webtrekk.android.sdk.WebtrekkConfiguration
import java.util.concurrent.TimeUnit

class SampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val constraints = Constraints.Builder()
            .setRequiresBatteryNotLow(true)
            .setRequiredNetworkType(NetworkType.CONNECTED).build()

        val webtrekkConfigurations =
            WebtrekkConfiguration.Builder(listOf("238713152098253"), "https://tracker-int-01.webtrekk.net")
                .logLevel(Logger.Level.BASIC)
                .requestsInterval(TimeUnit.MINUTES, 15)
                .workManagerConstraints(constraints = constraints)
                .setBatchSupport(true)
                .build()

        Webtrekk.getInstance().init(this, webtrekkConfigurations)
    }

}