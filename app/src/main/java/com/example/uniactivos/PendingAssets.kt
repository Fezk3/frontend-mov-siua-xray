package com.example.uniactivos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

class PendingAssets : Fragment(R.layout.fragment_pending_assets) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var btnDetalle = view.findViewById<View>(R.id.btn_accept)

        btnDetalle.setOnClickListener {
            findNavController().navigate(R.id.action_pendingAssets_to_receiveStatics)
        }
    }
}