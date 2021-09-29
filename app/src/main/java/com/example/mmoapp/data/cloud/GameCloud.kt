package com.example.mmoapp.data.cloud

import com.example.mmoapp.core.Abstract
import com.example.mmoapp.data.GameData
import com.example.mmoapp.data.ToGameMapper
import com.google.gson.annotations.SerializedName

data class GameCloud(
    @SerializedName("id")
    private val id: Int,
    @SerializedName("title")
    private val title: String,
    @SerializedName("short_description")
    private val description: String,
    @SerializedName("genre")
    private val genre: String,
    @SerializedName("platform")
    private val platform: String,
    @SerializedName("developer")
    private val developer: String,
    @SerializedName("release_date")
    private val releaseDate: String
) : Abstract.Object<GameData, ToGameMapper> {
    override fun map(mapper: ToGameMapper) =
        mapper.map(id, title, description, genre, platform, developer, releaseDate)
}