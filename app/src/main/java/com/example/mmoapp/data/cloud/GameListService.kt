package com.example.mmoapp.data.cloud

import okhttp3.ResponseBody
import retrofit2.http.GET

interface GameListService {
    @GET("games")
    suspend fun fetchGameList(): ResponseBody
}