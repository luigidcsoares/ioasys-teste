package br.com.ioasys.teste.ui.login

import androidx.lifecycle.ViewModel
import br.com.ioasys.teste.data.AuthRequest
import br.com.ioasys.teste.data.UserRepository

@Suppress("UNCHECKED_CAST")
class LoginViewModel(private val userRepository: UserRepository)
    : ViewModel() {

    fun auth(authRequest: AuthRequest) {
        android.util.Log.i("USUARIO", authRequest.toString())
        userRepository.auth(authRequest)
    }
}
