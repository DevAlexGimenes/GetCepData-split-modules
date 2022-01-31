package com.alex.app.getcepdataapp.data.di

import com.alex.app.getcepdataapp.data.api.CepDataRemoteSource
import com.alex.app.getcepdataapp.data.api.ServiceFactory
import com.alex.app.getcepdataapp.data.repository.CepDataRepositoryImpl
import com.alex.app.getcepdataapp.domain.repository.CepDataRepository
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val KOIN_RETROFIT = "retrofit"
const val KOIN_OKHTTP = "okhttp"

val dataModule = module {
    single<CepDataRepository> {
        CepDataRepositoryImpl(get())
    }

    single {
        Gson()
    }

    single {
        GsonConverterFactory.create(get<Gson>())
    }

    single {
        HttpLoggingInterceptor().apply {
            level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                else HttpLoggingInterceptor.Level.NONE
        }
    }

    single(named(KOIN_OKHTTP)) {
        OkHttpClient().newBuilder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    single(named(KOIN_RETROFIT)) {
        Retrofit
            .Builder()
            .baseUrl("https://viacep.com.br/ws/")
            .addConverterFactory(get<GsonConverterFactory>())
            .client(get(named(KOIN_OKHTTP)))
            .build()
    }

    single {
        ServiceFactory.createService(
            get(named(KOIN_RETROFIT)),
            CepDataRemoteSource::class.java
        )
    }
}