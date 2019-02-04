package br.com.ioasys.teste.ui.home

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import br.com.ioasys.teste.R
import br.com.ioasys.teste.utils.Injector

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel

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

        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this, Injector.provideHomeViewModelFactory())
            .get(HomeViewModel::class.java)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options, menu)

        // Configure SearchView functionalities.
        (menu.findItem(R.id.search).actionView as SearchView)
            .setOnQueryTextListener(object: SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    query?.let { viewModel.search(it) }
                    return true
                }

                override fun onQueryTextChange(newText: String?) = false
        })
    }

}
