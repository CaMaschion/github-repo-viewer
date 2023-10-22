package com.camila.githubrepoviewer.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.camila.githubrepoviewer.adapter.RepositoryAdapter
import com.camila.githubrepoviewer.databinding.RecyclerViewRepositoriesBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings

@AndroidEntryPoint
class RecycleViewFragment : Fragment() {

    private val viewModel: RepositoryViewModel by viewModels()
    private lateinit var binding: RecyclerViewRepositoriesBinding
    private lateinit var recycler: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RecyclerViewRepositoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler = binding.recyclerView
        recycler.layoutManager = LinearLayoutManager(context)
        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.loadRepositories()
        viewModel.repositories.observe(viewLifecycleOwner) {
            recycler.adapter = RepositoryAdapter(it)
        }
    }
}