package com.alex.app.getcepdataapp.cep.consult

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alex.app.getcepdataapp.R
import kotlinx.android.synthetic.main.fragment_consult_cep.*


class ConsultCepFragment : Fragment(R.layout.fragment_consult_cep) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareComponents()
    }


    private fun prepareComponents() {
        val cep = txtInput.text

        btnConsult.setOnClickListener {
            if (cep.isEmpty() || cep.length < 8) {
                txtInput.error = "Por favor, digite um cep válido!"
            } else {
                findNavController().navigate(R.id.action_consultCepFragment_to_showResultDataCepFragment2)
//                val action = ConsultCepFragmentDirections
//                    .actionConsultCepFragmentToShowResultDataCepFragment2()
//                findNavController().navigate(action)
            }
        }
    }
}