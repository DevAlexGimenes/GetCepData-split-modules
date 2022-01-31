package com.alex.app.getcepdataapp.domain.di

import com.alex.app.getcepdataapp.domain.usecase.CepDataUseCase
import com.alex.app.getcepdataapp.domain.usecase.CepDataUseCaseImpl
import org.koin.dsl.module

val domainModule = module {

    single<CepDataUseCase> {
        CepDataUseCaseImpl(get())
    }
}