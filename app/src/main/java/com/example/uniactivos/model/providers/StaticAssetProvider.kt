package com.example.uniactivos.model.providers

import com.example.uniactivos.model.AssetTypeDetails
import com.example.uniactivos.model.AssetsDetails

class StaticAssetProvider {
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
                4,
                AssetTypeDetails(
                    1,
                    "Dinámico"
                ),
            ),
            AssetsDetails(
                1,
                "aa",
                2,
                AssetTypeDetails(
                    1,
                    "Dinámico"
                ),
            ),
            AssetsDetails(
                1,
                "bb",
                3,
                AssetTypeDetails(
                    1,
                    "Dinámico"
                ),
            ),
            AssetsDetails(
                1,
                "cc",
                2,
                AssetTypeDetails(
                    1,
                    "Dinámico"
                ),
            ),
            AssetsDetails(
                1,
                "dd",
                3,
                AssetTypeDetails(
                    1,
                    "Dinámico"
                ),
            ),
        )
    }
}