package com.alex.app.getcepdataapp.cep.result

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.alex.app.getcepdataapp.R
import com.alex.app.getcepdataapp.domain.model.CepInformation
import kotlinx.android.synthetic.main.fragment_show_result_data_cep.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ShowResultDataCepFragment : Fragment(R.layout.fragment_show_result_data_cep) {

    private val viewModel: ShowResultDataCepViewModel by viewModel()

    private val args: ShowResultDataCepFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareObservers()
        prepareToolbar()

    }

    private fun prepareToolbar() {
        toolbar.title = "Cep: ${args.cep}"
        toolbar.setTitleTextColor(Color.BLACK)
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun prepareObservers() {
        viewModel.getCepData(args.cep)

        viewModel
            .cepData()
            .observe(viewLifecycleOwner, { dataCep ->
                plotDataOnScreen(dataCep)
                copyData(dataCep)
            })
    }

    private fun plotDataOnScreen(dataCep: CepInformation) {
        txtCep.text = dataCep.cep
        txtLogradouro.text = dataCep.street
        txtComplemento.text = dataCep.complement
        txtBairro.text = dataCep.district
        txtLocalidade.text = dataCep.location
        txtUf.text = dataCep.city
        txtDdd.text = dataCep.ddd
    }

    private fun copyData(dataCep: CepInformation) {

        imgCopyCep.setOnClickListener {
            try {
                val clipboard =
                    context?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager?
                val clip = ClipData.newPlainText("Text cep", dataCep.cep)
                clipboard?.setPrimaryClip(clip)
                Toast.makeText(context, "Copiado com sucesso! ${dataCep.cep}", Toast.LENGTH_SHORT)
                    .show()
            } catch (e: Exception) {
                Toast.makeText(context, "Erro ao copiar", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        imgCopyStreet.setOnClickListener {
            try {
                val clipboard =
                    context?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager?
                val clip = ClipData.newPlainText("Text street", dataCep.street)
                clipboard?.setPrimaryClip(clip)
                Toast.makeText(
                    context,
                    "Copiado com sucesso! ${dataCep.street}",
                    Toast.LENGTH_SHORT
                )
                    .show()
            } catch (e: Exception) {
                Toast.makeText(context, "Erro ao copiar", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        imgCopyComplement.setOnClickListener {
            try {
                val clipboard =
                    context?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager?
                val clip = ClipData.newPlainText("Text street", dataCep.complement)
                clipboard?.setPrimaryClip(clip)
                Toast.makeText(
                    context,
                    "Copiado com sucesso! ${dataCep.complement}",
                    Toast.LENGTH_SHORT
                )
                    .show()
            } catch (e: Exception) {
                Toast.makeText(context, "Erro ao copiar", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        imgCopyDistrict.setOnClickListener {
            try {
                val clipboard =
                    context?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager?
                val clip = ClipData.newPlainText("Text street", dataCep.district)
                clipboard?.setPrimaryClip(clip)
                Toast.makeText(
                    context,
                    "Copiado com sucesso! ${dataCep.district}",
                    Toast.LENGTH_SHORT
                )
                    .show()
            } catch (e: Exception) {
                Toast.makeText(context, "Erro ao copiar", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        imgCopyLocation.setOnClickListener {
            try {
                val clipboard =
                    context?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager?
                val clip = ClipData.newPlainText("Text street", dataCep.location)
                clipboard?.setPrimaryClip(clip)
                Toast.makeText(
                    context,
                    "Copiado com sucesso! ${dataCep.location}",
                    Toast.LENGTH_SHORT
                )
                    .show()
            } catch (e: Exception) {
                Toast.makeText(context, "Erro ao copiar", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        imgCopyCity.setOnClickListener {
            try {
                val clipboard =
                    context?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager?
                val clip = ClipData.newPlainText("Text street", dataCep.city)
                clipboard?.setPrimaryClip(clip)
                Toast.makeText(
                    context,
                    "Copiado com sucesso! ${dataCep.city}",
                    Toast.LENGTH_SHORT
                )
                    .show()
            } catch (e: Exception) {
                Toast.makeText(context, "Erro ao copiar", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        imgCopyDdd.setOnClickListener {
            try {
                val clipboard =
                    context?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager?
                val clip = ClipData.newPlainText("Text street", dataCep.ddd)
                clipboard?.setPrimaryClip(clip)
                Toast.makeText(
                    context,
                    "Copiado com sucesso! ${dataCep.ddd}",
                    Toast.LENGTH_SHORT
                )
                    .show()
            } catch (e: Exception) {
                Toast.makeText(context, "Erro ao copiar", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}