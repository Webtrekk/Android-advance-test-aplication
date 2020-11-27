package com.webtrekk.example

import android.app.Application
import androidx.camera.camera2.Camera2Config
import androidx.camera.core.CameraXConfig
import androidx.work.Constraints
import androidx.work.NetworkType
import com.webtrekk.example.utils.MappSharedPrefs
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
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
        val trackingId = MappSharedPrefs(this).trackingId
        val trackingDomain = MappSharedPrefs(this).trackingDomain
        val webtrekkConfigurations =
            WebtrekkConfiguration.Builder(
                listOf(trackingId),
                trackingDomain
            )
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