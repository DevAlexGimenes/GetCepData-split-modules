package com.alex.app.getcepdataapp.data.api

import com.alex.app.getcepdataapp.domain.model.CepInformation
import retrofit2.http.GET
import retrofit2.http.Path

interface CepDataRemoteSource {
    @GET("{cep}/json")
    suspend fun getCepData(
        @Path("cep") cep: String
    ) : CepInformation
}