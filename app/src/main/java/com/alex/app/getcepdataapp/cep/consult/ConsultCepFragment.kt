package com.alex.app.getcepdataapp.cep.consult

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alex.app.getcepdataapp.R
import com.alex.app.getcepdataapp.databinding.FragmentConsultCepBinding


class ConsultCepFragment : Fragment(R.layout.fragment_consult_cep) {

    private lateinit var binding: FragmentConsultCepBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConsultCepBinding.inflate(inflater)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        prepareComponents()
        binding.txtInput.text.clear()
    }

    private fun prepareComponents() {
        val cep = binding.txtInput.text

        binding.btnConsult.setOnClickListener {
            if (cep.isEmpty() || cep.length < 8) {
                binding.txtInput.error = "Por favor, digite um cep válido!"
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