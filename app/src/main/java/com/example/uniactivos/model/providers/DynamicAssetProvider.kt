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
                3,
                AssetTypeDetails(
                    1,
                    "Dinámico"
                ),
            ),
            AssetsDetails(
                1,
                "aa",
                4,
                AssetTypeDetails(
                    1,
                    "Dinámico"
                ),
            ),
            AssetsDetails(
                1,
                "bb",
                5,
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