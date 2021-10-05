package com.example.mmoapp.data.special.cloud

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path

interface SpecialService {
    @GET("game?id={specialId}")
    suspend fun fetchSpecial(
        @Path("specialId") specialId: Int
    ): ResponseBody
}