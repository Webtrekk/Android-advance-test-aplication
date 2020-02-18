package com.example.android_advanced_test_application

import android.app.Application
import androidx.camera.camera2.Camera2Config
import androidx.camera.core.CameraXConfig
import androidx.work.Constraints
import androidx.work.NetworkType
import webtrekk.android.sdk.Logger
import webtrekk.android.sdk.Webtrekk
import webtrekk.android.sdk.WebtrekkConfiguration
import java.util.concurrent.TimeUnit

class AndroidAdvancedTestApplication : Application(), CameraXConfig.Provider {

    override fun onCreate() {
        super.onCreate()

        val constraints = Constraints.Builder()
            .setRequiresBatteryNotLow(true)
            .setRequiredNetworkType(NetworkType.CONNECTED).build()

        val webtrekkConfigurations =
            WebtrekkConfiguration.Builder(listOf("658572554704007"), "https://webtrekkdemoapp01.wt-eu02.net")
                .logLevel(Logger.Level.BASIC)
                .requestsInterval(TimeUnit.MINUTES, 15)
                .workManagerConstraints(constraints = constraints)
                .setBatchSupport(true)
                .build()

        Webtrekk.getInstance().init(this, webtrekkConfigurations)
    }

    /** @returns Camera2 default configuration */
    override fun getCameraXConfig(): CameraXConfig {
        return Camera2Config.defaultConfig()
    }
}