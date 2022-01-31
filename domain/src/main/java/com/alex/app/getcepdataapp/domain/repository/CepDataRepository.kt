package com.alex.app.getcepdataapp.domain.repository

import com.alex.app.getcepdataapp.domain.model.CepInformation

interface CepDataRepository {

    suspend fun getCepData(cep: String) : CepInformation

}