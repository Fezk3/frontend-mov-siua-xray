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
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.mainContainer) as NavHostFragment
        val navController = navHostFragment.navController

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        val username = intent.getStringExtra("username")

        when (username) {
            "profe@gmail.com" -> {
                bottomNavigationView.inflateMenu(R.menu.navegation)
                navController.graph = navController.navInflater.inflate(R.navigation.nav_graph)
            }
            "guarda@gmail.com" -> {
                bottomNavigationView.inflateMenu(R.menu.navegation_guarda)
                navController.graph = navController.navInflater.inflate(R.navigation.nav_guarda)
            }
        }

        bottomNavigationView.setupWithNavController(navController)
    }
}