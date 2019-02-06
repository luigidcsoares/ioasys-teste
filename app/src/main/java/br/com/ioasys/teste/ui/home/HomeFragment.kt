package br.com.ioasys.teste.ui.home

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import br.com.ioasys.teste.CustomSearchView
import br.com.ioasys.teste.R
import br.com.ioasys.teste.databinding.HomeFragmentBinding
import br.com.ioasys.teste.utils.Injector
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProviders.of(this, Injector.provideHomeViewModelFactory())
            .get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Set app status bar color.
        activity?.window?.statusBarColor =
            ContextCompat.getColor(context as Context, R.color.dark_pink)

        // Show app toolbar.
        (activity as AppCompatActivity).supportActionBar?.show()

        // Set up toolbar options.
        setHasOptionsMenu(true)

        return HomeFragmentBinding.inflate(inflater, container, false).let {
            it.adapter = EnterprisesAdapter(emptyList())
            it.setLifecycleOwner(this)
            it.root
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options, menu)

        // Configure SearchView.
        val searchView = menu.findItem(R.id.search).actionView as CustomSearchView
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                CoroutineScope(Dispatchers.Main).launch {

                }

                return true
            }

            override fun onQueryTextChange(newText: String?) = true
        })
    }

}
