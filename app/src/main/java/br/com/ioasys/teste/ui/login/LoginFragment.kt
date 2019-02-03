package br.com.ioasys.teste.ui.login

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import br.com.ioasys.teste.R
import br.com.ioasys.teste.data.AuthRequest
import br.com.ioasys.teste.data.AuthResponse
import br.com.ioasys.teste.data.EnterpriseRepository
import br.com.ioasys.teste.utils.Injector
import com.google.android.material.textfield.TextInputEditText

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Set the login status bar color.
        activity?.window?.statusBarColor =
            ContextCompat.getColor(context as Context, R.color.black_23)

        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // Create the view model using a factory.
        viewModel = ViewModelProviders.of(this, Injector.provideLoginViewModelFactory())
            .get(LoginViewModel::class.java)

        val emailField = activity?.findViewById<TextInputEditText>(R.id.login_email)
        val passwordField = activity?.findViewById<TextInputEditText>(R.id.login_password)

        activity?.findViewById<Button>(R.id.login_button)?.setOnClickListener {
            viewModel.auth(AuthRequest(emailField?.text.toString(), passwordField?.text.toString()))
                .observe(activity!!, Observer<AuthResponse> {
                    if (it.success) {
                        Toast.makeText(activity, "BOAAAAAAA", Toast.LENGTH_LONG).show()
                        EnterpriseRepository.enterprises("aQm")
                    } else {
                        Toast.makeText(activity, getString(R.string.login_failure), Toast.LENGTH_LONG).show()
                    }
                })
        }
    }

}
