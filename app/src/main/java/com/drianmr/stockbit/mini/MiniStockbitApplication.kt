package com.drianmr.stockbit.mini

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MiniStockbitApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // Disable night theme
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}
