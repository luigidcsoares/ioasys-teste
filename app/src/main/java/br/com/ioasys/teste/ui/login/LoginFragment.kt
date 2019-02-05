package br.com.ioasys.teste.ui.login

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import br.com.ioasys.teste.R
import br.com.ioasys.teste.data.investor.Investor
import br.com.ioasys.teste.utils.Injector
import com.google.android.material.textfield.TextInputEditText
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

        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val emailField = activity?.findViewById<TextInputEditText>(R.id.login_email)
        val passwordField = activity?.findViewById<TextInputEditText>(R.id.login_password)

        activity?.findViewById<Button>(R.id.login_button)
            ?.setOnClickListener {
                CoroutineScope(Dispatchers.Main).launch {
                    val success = viewModel.auth(Investor(
                        email = emailField?.text.toString(),
                        password = passwordField?.text.toString())
                    )

                    if (success) {
                        // Prevent app crashing with multiple clicks.
                        val navController = findNavController()
                        if (navController.currentDestination?.id == R.id.login_fragment) {
                            navController.navigate(R.id.action_login)
                        }
                    } else {
                        Toast.makeText(activity, getString(R.string.login_failure), Toast.LENGTH_LONG).show()
                    }
                }
            }

/*        loginButton?.setOnClickListener {
            viewModel.auth(Investor(
                email = emailField?.text.toString(),
                password = passwordField?.text.toString()
            )
            ).observe(activity!!, Observer<AuthResponse> {
                if (it.success) {
                } else {
                }
            })
        }  */
    }

}
