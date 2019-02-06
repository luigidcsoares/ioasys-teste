package br.com.ioasys.teste.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.ioasys.teste.data.enterprise.Enterprise
import br.com.ioasys.teste.databinding.EnterpriseListItemBinding

class EnterprisesAdapter(private val enterprises: List<Enterprise>)
    : RecyclerView.Adapter<EnterprisesAdapter.EnterpriseViewHolder>() {

    class EnterpriseViewHolder(private val binding: EnterpriseListItemBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(enterprise: Enterprise) {
            // TODO: receive image from request.
            binding.enterprise = enterprise
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        EnterpriseViewHolder(EnterpriseListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount() = enterprises.size

    override fun onBindViewHolder(holder: EnterpriseViewHolder, position: Int) {
        holder.bind(enterprises[position])
    }

}