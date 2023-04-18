package com.example.uniactivos.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.uniactivos.R

class PendingAssets : Fragment(R.layout.fragment_pending_assets) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var btnDetalle = view.findViewById<View>(R.id.btn_accept)

        btnDetalle.setOnClickListener {
            findNavController().navigate(R.id.action_pendingAssets_to_receiveStatics)
        }
    }
}