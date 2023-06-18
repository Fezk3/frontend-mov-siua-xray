package com.example.uniactivos.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.uniactivos.databinding.ActivityLoginBinding
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.uniactivos.R
import com.example.uniactivos.model.UserLoginInput
import com.example.uniactivos.utils.SessionManager
import com.example.uniactivos.model.LoggedInUserView
import com.example.uniactivos.viewmodel.LoginViewModel
import com.example.uniactivos.viewmodel.LoginViewModelFactory

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var sessionManager: SessionManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val btnLiciniaSession = binding.btnLoginIrMenu
        btnLiciniaSession.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // LoginViewModelFactory
        loginViewModel =
            ViewModelProvider(this, LoginViewModelFactory())[LoginViewModel::class.java]

        loginViewModel.loginFormState.observe(this@LoginActivity, Observer {
            val loginState = it ?: return@Observer

            // disable login button unless both email / password is valid
            binding.btnLoginIrMenu.isEnabled = loginState.isDataValid

            if (loginState.emailError != null) {
                binding.email.error = getString(loginState.emailError)
            }
            if (loginState.passwordError != null) {
                binding.password.error = getString(loginState.passwordError)
            }
        })

        loginViewModel.loginResponse.observe(this@LoginActivity, Observer {
            val loginResult = it ?: return@Observer

            binding.loading.visibility = View.GONE
            if (loginResult.error != null) {
                showLoginFailed(loginResult.error)
            }
            if (loginResult.success != null) {
                updateUiWithUser(loginResult.success)
            }
            setResult(Activity.RESULT_OK)

            //Complete and destroy login activity once successful
            finish()
        })

        binding.email.afterTextChanged {
            loginViewModel.loginDataChanged(
                UserLoginInput(
                    email = binding.email.text.toString(),
                    password = binding.password.text.toString()
                )
            )
        }

        binding.password.apply {
            afterTextChanged {
                loginViewModel.loginDataChanged(
                    UserLoginInput(
                        email = binding.email.text.toString(),
                        password = binding.password.text.toString()
                    )
                )
            }

            setOnEditorActionListener { _, actionId, _ ->
                when (actionId) {
                    EditorInfo.IME_ACTION_DONE ->
                        loginViewModel.login(
                            UserLoginInput(
                                email = binding.email.text.toString(),
                                password = binding.password.text.toString()
                            )
                        )
                }
                false
            }

            binding.btnLoginIrMenu.setOnClickListener {
                binding.loading.visibility = View.VISIBLE
                loginViewModel.login(
                    UserLoginInput(
                        email = binding.email.text.toString(),
                        password = binding.password.text.toString()
                    )
                )
            }
        }

    }
}