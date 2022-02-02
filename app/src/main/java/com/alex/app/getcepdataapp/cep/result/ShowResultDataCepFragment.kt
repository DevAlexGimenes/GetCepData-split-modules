package com.alex.app.getcepdataapp.cep.result

import android.app.AlertDialog
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
import kotlinx.android.synthetic.main.notify_error.view.*
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
        toolbar.title = getString(R.string.txt_title_result)
        toolbar.setTitleTextColor(Color.BLACK)
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun prepareObservers() {
        viewModel.getCepData(args.cep)

        val view = View.inflate(context, R.layout.notify_loading, null)
        val builder = AlertDialog.Builder(context)
        builder.setView(view)
        val dialog = builder.create()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.show()
        dialog.setCanceledOnTouchOutside(false)

        viewModel
            .cepData()
            .observe(viewLifecycleOwner, { dataCep ->
                dialog.dismiss()
                plotDataOnScreen(dataCep)
                copyData(dataCep)
            })

        viewModel
            .notifyError()
            .observe(viewLifecycleOwner, {
                dialog.dismiss()
                initNotifyError()
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
                Toast.makeText(
                    context,
                    getString(R.string.txt_success_copy, dataCep.cep),
                    Toast.LENGTH_SHORT
                )
                    .show()
            } catch (e: Exception) {
                Toast.makeText(context, getString(R.string.txt_error_copy), Toast.LENGTH_SHORT)
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
                    getString(R.string.txt_success_copy, dataCep.street),
                    Toast.LENGTH_SHORT
                )
                    .show()
            } catch (e: Exception) {
                Toast.makeText(context, getString(R.string.txt_error_copy), Toast.LENGTH_SHORT)
                    .show()
            }
        }

        imgCopyComplement.setOnClickListener {
            try {
                val clipboard =
                    context?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager?
                val clip = ClipData.newPlainText("Text complement", dataCep.complement)
                clipboard?.setPrimaryClip(clip)
                Toast.makeText(
                    context,
                    getString(R.string.txt_success_copy, dataCep.complement),
                    Toast.LENGTH_SHORT
                )
                    .show()
            } catch (e: Exception) {
                Toast.makeText(context, getString(R.string.txt_error_copy), Toast.LENGTH_SHORT)
                    .show()
            }
        }

        imgCopyDistrict.setOnClickListener {
            try {
                val clipboard =
                    context?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager?
                val clip = ClipData.newPlainText("Text district", dataCep.district)
                clipboard?.setPrimaryClip(clip)
                Toast.makeText(
                    context,
                    getString(R.string.txt_success_copy, dataCep.district),
                    Toast.LENGTH_SHORT
                )
                    .show()
            } catch (e: Exception) {
                Toast.makeText(context, getString(R.string.txt_error_copy), Toast.LENGTH_SHORT)
                    .show()
            }
        }

        imgCopyLocation.setOnClickListener {
            try {
                val clipboard =
                    context?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager?
                val clip = ClipData.newPlainText("Text location", dataCep.location)
                clipboard?.setPrimaryClip(clip)
                Toast.makeText(
                    context,
                    getString(R.string.txt_success_copy, dataCep.location),
                    Toast.LENGTH_SHORT
                )
                    .show()
            } catch (e: Exception) {
                Toast.makeText(context, getString(R.string.txt_error_copy), Toast.LENGTH_SHORT)
                    .show()
            }
        }

        imgCopyCity.setOnClickListener {
            try {
                val clipboard =
                    context?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager?
                val clip = ClipData.newPlainText("Text city", dataCep.city)
                clipboard?.setPrimaryClip(clip)
                Toast.makeText(
                    context,
                    getString(R.string.txt_success_copy, dataCep.city),
                    Toast.LENGTH_SHORT
                )
                    .show()
            } catch (e: Exception) {
                Toast.makeText(context, getString(R.string.txt_error_copy), Toast.LENGTH_SHORT)
                    .show()
            }
        }

        imgCopyDdd.setOnClickListener {
            try {
                val clipboard =
                    context?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager?
                val clip = ClipData.newPlainText("Text ddd", dataCep.ddd)
                clipboard?.setPrimaryClip(clip)
                Toast.makeText(
                    context,
                    getString(R.string.txt_success_copy, dataCep.ddd),
                    Toast.LENGTH_SHORT
                )
                    .show()
            } catch (e: Exception) {
                Toast.makeText(context, getString(R.string.txt_error_copy), Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun initNotifyError() {
        val view = View.inflate(context, R.layout.notify_error, null)
        val builder = AlertDialog.Builder(context)
        builder.setView(view)
        val dialog = builder.create()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.show()
        view.btnBack.setOnClickListener {
            dialog.dismiss()
            findNavController().navigateUp()
        }
    }
}