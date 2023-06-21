package com.example.uniactivos.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.uniactivos.R
import com.example.uniactivos.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.mainContainer) as NavHostFragment
        val navController = navHostFragment.navController

        when (intent.getStringExtra("rol")) {
            "admin" -> navController.navigate(R.id.nav_admin)
            "profesor" -> navController.navigate(R.id.nav_graph)
            "guarda" -> navController.navigate(R.id.nav_guarda)
            else -> navController.navigate(R.id.nav_guarda) // Por defecto, en caso de un rol no reconocido
        }
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setupWithNavController(navController)
    }
}