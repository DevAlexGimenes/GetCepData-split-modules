package com.alex.app.getcepdataapp.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CepDataApiService {
    companion object {
        private const val BASE_URL = "https://viacep.com.br/ws/"
        private var retrofit: Retrofit? = null

        fun getInstance(): Retrofit {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
    }
}