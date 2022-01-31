package com.alex.app.getcepdataapp.di

import com.alex.app.getcepdataapp.cep.result.ShowResultDataCepViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel {
        ShowResultDataCepViewModel(get())
    }

}