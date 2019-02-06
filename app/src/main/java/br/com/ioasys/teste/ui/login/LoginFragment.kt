package br.com.ioasys.teste.ui.login

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import br.com.ioasys.teste.R
import br.com.ioasys.teste.data.investor.Investor
import br.com.ioasys.teste.databinding.LoginFragmentBinding
import br.com.ioasys.teste.utils.Injector
import kotlinx.coroutines.*

class LoginFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProviders.of(this, Injector.provideLoginViewModelFactory())
            .get(LoginViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Hide app toolbar.
        (activity as AppCompatActivity).supportActionBar?.hide()

        return LoginFragmentBinding.inflate(inflater, container, false).run {
            loginButton.setOnClickListener {
                CoroutineScope(Dispatchers.Main).launch {
                    // Prevent app crashing with multiple clicks.
                    it.isEnabled = false

                    val success = viewModel.auth(Investor(email = email, password = password))

                    if (success) findNavController()
                        .navigate(R.id.action_login)
                    else Toast
                        .makeText(activity, getString(R.string.login_failure), Toast.LENGTH_LONG)
                        .show()
                        .apply { it.isEnabled = true }
                }
            }

            root
        }
    }

}
