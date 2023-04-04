package com.example.uniactivos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // cargando el fragmento de login
        supportFragmentManager.commit {
            replace<MainMenu>(R.id.frameContainer)
            setReorderingAllowed(true)
            addToBackStack("replacement")
        }

    }

}