package com.alex.app.getcepdataapp.cep.result

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.alex.app.getcepdataapp.R
import kotlinx.android.synthetic.main.fragment_show_result_data_cep.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ShowResultDataCepFragment : Fragment(R.layout.fragment_show_result_data_cep) {

    private val viewModel: ShowResultDataCepViewModel by viewModel()

    private val args: ShowResultDataCepFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareObservers()

    }
    private fun prepareObservers() {
        viewModel.getCepData(args.cep)

        viewModel
            .cepData()
            .observe(viewLifecycleOwner, {
                txtTeste.text = it.cep
            })
    }

}