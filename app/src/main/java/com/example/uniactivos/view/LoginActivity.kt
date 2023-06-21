package com.example.uniactivos.view

import io.jsonwebtoken.Claims
import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.uniactivos.databinding.ActivityLoginBinding
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
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
import com.example.uniactivos.utils.MyApplication
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

        /*val btnLiciniaSession = binding.btnLoginIrMenu
        btnLiciniaSession.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }*/

        sessionManager = SessionManager(this)

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
    /**
     * Success login to redirect the app to the next Screen
     */
    /*fun obtenerTokenUsuarioLogueado(context: Context): String? {
        var token: String? = null
        MyApplication.sessionManager?.fetchAuthToken()?.let {
            token = it
            Log.d("Authorization", it)
        }
        return token
    }

    fun obtenerRolUsuarioDesdeTokenJWT(tokenJWT: String): String? {
        try {
            val claims: Claims = Jwts.parser().parseClaimsJwt(tokenJWT).body
            return claims.get("rol", String::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    } */

    private fun updateUiWithUser(model: LoggedInUserView) {
        val welcome = getString(R.string.welcome)
        val username = model.username
        //val firstName = model.firstName
        //val rol = model.roleList?.get(0)?.name.toString()
        //Log.d("Username", username)
        //Log.d("Rol", rol)
        //Log.d("FirstName", firstName)
        /*MyApplication.sessionManager?.fetchAuthToken()?.let {
            Log.d("Authorization", it)
        }*/

        //val auth = model.authorities.get(0).authority
        //Log.d("Authorities", auth)

        // If token has been saved, add it to the request

        /*val tokenUsuario = obtenerTokenUsuarioLogueado(this)

        if (tokenUsuario != null) {
            // Aquí puedes hacer lo que necesites con el token del usuario logueado
            Log.d("Token del usuario logueado:", tokenUsuario)
        } else {
            // Manejar el caso de que no se pueda obtener el token del usuario logueado
            println("No se pudo obtener el token del usuario logueado")
        }*/

        val rol = "profesor"
        // Initiate successful logged in experience
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("rol", rol)
        startActivity(intent)

        Toast.makeText(
            applicationContext,
            "$welcome $username",
            Toast.LENGTH_LONG
        ).show()
    }

    /**
     * Unsuccessful login
     */
    private fun showLoginFailed(@StringRes errorString: Int) {
        Toast.makeText(applicationContext, errorString, Toast.LENGTH_SHORT).show()
    }
}

/**
 * Extension function to simplify setting an afterTextChanged action to EditText components.
 */
fun EditText.

        afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
    })
}