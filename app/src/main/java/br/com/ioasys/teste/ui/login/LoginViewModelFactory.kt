package br.com.ioasys.teste.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.ioasys.teste.data.UserRepository

@Suppress("UNCHECKED_CAST")
class LoginViewModelFactory(private val userRepository: UserRepository)
    : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>) =
            LoginViewModel(userRepository) as T
}