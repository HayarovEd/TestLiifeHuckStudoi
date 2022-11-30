package com.edurda77.testliifehuckstudoi.ui.company

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.edurda77.testliifehuckstudoi.R
import com.edurda77.testliifehuckstudoi.databinding.FragmentCompanyBinding
import com.edurda77.testliifehuckstudoi.domain.BASE_URL
import com.edurda77.testliifehuckstudoi.domain.DATA_TO_COMPANY
import com.edurda77.testliifehuckstudoi.domain.entity.CompanyData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CompanyFragment : Fragment() {
    private var _binding: FragmentCompanyBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<CompanyViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCompanyBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val idCompany = arguments?.getString(DATA_TO_COMPANY)
        viewModel.getCompanyData(id = idCompany?: "")
        viewModel.companyData.observe(viewLifecycleOwner) {
            when (it) {
                is CompanyFragmentState.Success -> {
                    binding.progressBar.isVisible = false
                    initData(it.data)
                }
                is CompanyFragmentState.Failure -> {
                    binding.progressBar.isVisible = false
                    Toast.makeText(requireContext(), it.error, Toast.LENGTH_LONG).show()
                }
                is CompanyFragmentState.Loading -> {
                    binding.progressBar.isVisible = true

                }
            }
        }
        binding.backBt.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_companyFragment_to_mainFragment, null)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun initData(data: CompanyData) {
        binding.nameCompanyTv.text = data.name
        binding.descriptionTv.text = data.description
        binding.latTv.text = "Широта: ${data.lat}"
        binding.longTv.text = "Долгота: ${data.lon}"
        binding.phoneTv.text = "Телефон: ${data.phone}"
        binding.webTv.text = "Сайт: ${data.website}"
        val urlPoster = BASE_URL + data.img
        Glide.with(this)
            .load(urlPoster)
            .placeholder(R.drawable.ic_no_image)
            .into(binding.imageCompanyIv)
    }
}