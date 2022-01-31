package com.alex.app.getcepdataapp.cep.result

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alex.app.getcepdataapp.domain.model.CepInformation
import com.alex.app.getcepdataapp.domain.usecase.CepDataUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ShowResultDataCepViewModel(
    private val cepDataUseCase: CepDataUseCase
) : ViewModel() {
    private val cepDataLv = MutableLiveData<CepInformation>()
    fun cepData(): MutableLiveData<CepInformation> = cepDataLv

    private val notifyErrorLv = MutableLiveData<Unit>()
    fun notifyError(): MutableLiveData<Unit> = notifyErrorLv

    fun getCepData(cep: String) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val cepData = withContext(Dispatchers.Default) {
                    cepDataUseCase.getCepData(cep)
                }
                cepDataLv.value = cepData
            } catch (e: Exception) {
                notifyErrorLv.postValue(Unit)
            }
        }
    }
}