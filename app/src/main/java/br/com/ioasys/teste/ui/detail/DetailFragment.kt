package br.com.ioasys.teste.ui.detail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs

import br.com.ioasys.teste.databinding.DetailFragmentBinding
import br.com.ioasys.teste.utils.Injector
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailFragment : Fragment() {

    private val args by navArgs<DetailFragmentArgs>()

    private val viewModel by lazy {
        ViewModelProviders.of(this, Injector.provideDetailViewModelFactory())
            .get(DetailViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        DetailFragmentBinding.inflate(inflater, container, false).let {
            it.setLifecycleOwner(this)

            CoroutineScope(Dispatchers.Main).launch {
                it.description = viewModel.show(args.id).description
            }

            it.root
        }

}


