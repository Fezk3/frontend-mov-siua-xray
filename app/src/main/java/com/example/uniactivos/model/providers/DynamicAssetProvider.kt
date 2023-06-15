package com.example.uniactivos.model.providers

import com.example.uniactivos.model.AssetsDetails
import com.example.uniactivos.model.AssetTypeDetails

class DynamicAssetProvider {
    companion object {
        fun findById(id: Int): AssetsDetails {
            return assetList[id]
        }

        fun findAllAssets(): List<AssetsDetails> {
            return assetList
        }

        val assetList = listOf<AssetsDetails>(
            AssetsDetails(
                1,
                "xx",
                AssetTypeDetails(
                    1,
                    "Dinámico"
                ),
            ),
            AssetsDetails(
                1,
                "aa",
                AssetTypeDetails(
                    1,
                    "Dinámico"
                ),
            ),
            AssetsDetails(
                1,
                "bb",
                AssetTypeDetails(
                    1,
                    "Dinámico"
                ),
            ),
            AssetsDetails(
                1,
                "cc",
                AssetTypeDetails(
                    1,
                    "Dinámico"
                ),
            ),
            AssetsDetails(
                1,
                "dd",
                AssetTypeDetails(
                    1,
                    "Dinámico"
                ),
            ),
        )
    }
}