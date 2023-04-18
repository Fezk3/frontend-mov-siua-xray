package com.example.uniactivos.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.uniactivos.R

/**
 * A simple [Fragment] subclass.
 * Use the [MainMenu.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainMenu : Fragment(R.layout.fragment_main_menu) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var btnAula = view.findViewById<View>(R.id.cardViewAula)
        var btnActivosProfesor = view.findViewById<View>(R.id.cardViewReciboProfesor)
        var btnReciboGuardas = view.findViewById<View>(R.id.cardreciboGuardas)
        var btnListaGuardas = view.findViewById<View>(R.id.cardViewReportesGuardas)
        var btnListaAulas = view.findViewById<View>(R.id.cardViewListaAulas)
        var btnReportesPending = view.findViewById<View>(R.id.cardViewReportesGuardasPending)


        btnAula.setOnClickListener{
            findNavController().navigate(R.id.action_mainMenu_to_aulas)
        }

        btnActivosProfesor.setOnClickListener{
            findNavController().navigate(R.id.action_mainMenu_to_mySchedule)
        }
        btnListaGuardas.setOnClickListener{
            findNavController().navigate(R.id.action_mainMenu_to_guardReports)
        }
        btnListaAulas.setOnClickListener{
            findNavController().navigate(R.id.action_mainMenu_to_aulas)
        }
        btnReciboGuardas.setOnClickListener{
            findNavController().navigate(R.id.action_mainMenu_to_pendingAssets)
        }
        btnReportesPending.setOnClickListener{
            findNavController().navigate(R.id.action_mainMenu_to_reports)
        }

    }
}