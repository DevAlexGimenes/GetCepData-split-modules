package com.alex.app.getcepdataapp.domain.usecase

import com.alex.app.getcepdataapp.domain.model.CepInformation
import com.alex.app.getcepdataapp.domain.repository.CepDataRepository

class CepDataUseCaseImpl(
    private val cepDataRepository: CepDataRepository
) : CepDataUseCase {

    override suspend fun getCepData(cep: String): CepInformation {
        return cepDataRepository.getCepData(cep)
    }

}