package com.alex.app.getcepdataapp.cep.consult

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alex.app.getcepdataapp.R
import kotlinx.android.synthetic.main.fragment_consult_cep.*


class ConsultCepFragment : Fragment(R.layout.fragment_consult_cep) {

    override fun onResume() {
        super.onResume()
        prepareComponents()
        txtInput.text.clear()
    }

    private fun prepareComponents() {
        val cep = txtInput.text

        btnConsult.setOnClickListener {
            if (cep.isEmpty() || cep.length < 8) {
                txtInput.error = "Por favor, digite um cep válido!"
            } else {
                val action = ConsultCepFragmentDirections
                    .actionConsultCepFragmentToShowResultDataCepFragment2(
                        cep = cep.toString()
                    )
                findNavController().navigate(action)
            }
        }
    }
}