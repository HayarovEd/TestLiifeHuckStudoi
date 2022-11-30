package com.edurda77.testliifehuckstudoi.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.edurda77.testliifehuckstudoi.R
import com.edurda77.testliifehuckstudoi.databinding.FragmentMainBinding
import com.edurda77.testliifehuckstudoi.domain.DATA_TO_COMPANY
import com.edurda77.testliifehuckstudoi.domain.entity.ItemCompany
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null

    private lateinit var mainAdapter: MainAdapter

    private val viewModel by viewModels<MainViewModel>()

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.allData.observe(viewLifecycleOwner) {
            when (it) {
                is MainFragmentState.Success -> {
                    binding.progressBar.isVisible = false
                    binding.dataRv.isVisible = true
                    initRecyclerView(it.data)
                }
                is MainFragmentState.Failure -> {
                    binding.progressBar.isVisible = false
                    binding.dataRv.isVisible = false
                    Toast.makeText(requireContext(), it.error, Toast.LENGTH_LONG).show()
                }
                is MainFragmentState.Loading -> {
                    binding.progressBar.isVisible = true
                    binding.dataRv.isVisible = false
                }
            }
        }
    }

    private fun initRecyclerView(companies: List<ItemCompany>) {
        val recyclerView: RecyclerView = binding.dataRv
        recyclerView.layoutManager = LinearLayoutManager(
            requireContext(), LinearLayoutManager
                .VERTICAL, false
        )
        val stateClickListener: MainAdapter.OnStateClickListener =
            object : MainAdapter.OnStateClickListener {
                override fun onStateClick(itemCompany: ItemCompany, position: Int) {
                    val bundle = bundleOf(DATA_TO_COMPANY to itemCompany.id)
                    view?.findNavController()
                        ?.navigate(R.id.action_mainFragment_to_companyFragment, bundle)
                }
            }
        mainAdapter = MainAdapter(stateClickListener)
        mainAdapter.differ.submitList(companies)
        recyclerView.adapter = mainAdapter

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}