package com.alex.app.getcepdataapp.data.repository

import com.alex.app.getcepdataapp.data.api.CepDataRemoteSource
import com.alex.app.getcepdataapp.domain.model.CepInformation
import com.alex.app.getcepdataapp.domain.repository.CepDataRepository
import kotlinx.coroutines.delay

class CepDataRepositoryImpl(
    private val cepDataRemoteSource: CepDataRemoteSource
) : CepDataRepository {

    override suspend fun getCepData(cep: String): CepInformation {
        delay(2000)
        return cepDataRemoteSource.getCepData(cep)
    }

}