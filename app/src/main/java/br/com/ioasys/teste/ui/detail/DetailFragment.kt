package br.com.ioasys.teste.ui.detail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.com.ioasys.teste.R
import br.com.ioasys.teste.utils.Injector

class DetailFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProviders.of(this, Injector.provideDetailViewModelFactory())
            .get(DetailViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }

}
