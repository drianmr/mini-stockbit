package com.drianmr.stockbit.mini.di.module

import com.drianmr.stockbit.mini.data.network.service.CryptoService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    fun provideCryptoService(retrofit: Retrofit): CryptoService =
        retrofit.create()
}
