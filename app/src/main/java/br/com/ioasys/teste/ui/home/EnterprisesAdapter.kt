package br.com.ioasys.teste.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.ioasys.teste.data.enterprise.Enterprise
import br.com.ioasys.teste.databinding.EnterpriseListItemBinding

class EnterprisesAdapter(private val enterprises: MutableList<Enterprise>,
                         private val onItemClickListener: OnItemClickListener)

    : RecyclerView.Adapter<EnterprisesAdapter.EnterpriseViewHolder>() {

    class EnterpriseViewHolder(private val binding: EnterpriseListItemBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(enterprise: Enterprise, onItemClickListener: OnItemClickListener) {
            // TODO: receive image from request.
            binding.enterprise = enterprise
            binding.executePendingBindings()

            itemView.setOnClickListener(object: View.OnClickListener {
                override fun onClick(v: View?) {
                    onItemClickListener.onItemClick(enterprise.id)
                }
            })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        EnterpriseViewHolder(EnterpriseListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount() = enterprises.size

    override fun onBindViewHolder(holder: EnterpriseViewHolder, position: Int) {
        holder.bind(enterprises[position], onItemClickListener)
    }

    fun setData(list: List<Enterprise>) {
        enterprises.apply {
            clear()
            addAll(list)
        }

        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClick(id: Int)
    }
}