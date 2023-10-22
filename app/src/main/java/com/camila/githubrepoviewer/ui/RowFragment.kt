package com.camila.githubrepoviewer.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.camila.githubrepoviewer.adapter.RepositoryAdapter
import com.camila.githubrepoviewer.databinding.RecyclerViewRepositoriesBinding

class RowFragment : Fragment() {

    private lateinit var viewModel: RepositoryViewModel
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