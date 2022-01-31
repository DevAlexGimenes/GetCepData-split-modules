package com.alex.app.getcepdataapp.domain.usecase

import com.alex.app.getcepdataapp.domain.model.CepInformation

interface CepDataUseCase {

    suspend fun getCepData(cep: String) : CepInformation

}