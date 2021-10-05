package com.example.mmoapp.data.special.cloud

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

interface SpecialCloudDataSource {
    suspend fun fetchSpecial(id: Int): SpecialCloud

    class Base(
        private val service: SpecialService,
        private val gson: Gson
    ) : SpecialCloudDataSource {
        override suspend fun fetchSpecial(id: Int): SpecialCloud =
            gson.fromJson(
                service.fetchSpecial(id).string(),
                object : TypeToken<SpecialCloud>() {}.type
            )
    }
}