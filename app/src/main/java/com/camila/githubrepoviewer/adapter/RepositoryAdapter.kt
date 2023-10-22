package com.camila.githubrepoviewer.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.camila.githubrepoviewer.databinding.FragmentRowBinding
import com.camila.githubrepoviewer.model.RepositoryModel

class RepositoryAdapter(
    private val repositoryModel: List<RepositoryModel>

) : RecyclerView.Adapter<RepositoryAdapter.GithubViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GithubViewHolder {
        val binding =
            FragmentRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return GithubViewHolder(binding)
    }

    override fun getItemCount(): Int = repositoryModel.size

    override fun onBindViewHolder(holder: GithubViewHolder, position: Int) =
        holder.bindItem(repositoryModel[position])

    inner class GithubViewHolder(binding: FragmentRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val avatar = binding.avatar
        private val repositoryName = binding.tvRepository

        fun bindItem(item: RepositoryModel) {
            repositoryName.text = item.repositoryName
            Glide.with(itemView.context).load(item.repositoryDetail.avatarUrl).circleCrop()
                .into(avatar)
        }
    }
}
