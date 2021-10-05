package com.example.mmoapp.data.special.cloud

import com.example.mmoapp.core.Abstract
import com.example.mmoapp.data.special.SpecialData
import com.example.mmoapp.data.special.ToSpecialMapper
import com.google.gson.annotations.SerializedName

data class SpecialCloud(
    @SerializedName("id")
    private val idGame: Int,
    @SerializedName("thumbnail")
    private val thumbnail: String,
    @SerializedName("short_description")
    private val short_description: String,
    @SerializedName("genre")
    private val genreGame: String,
    @SerializedName("platform")
    private val platformGame: String,
    @SerializedName("developer")
    private val developerGame: String,
    @SerializedName("release_date")
    private val releaseDateGame: String,
    @SerializedName("os")
    private val os: String,
    @SerializedName("processor")
    private val processor: String,
    @SerializedName("memory")
    private val memory: String,
    @SerializedName("graphics")
    private val graphics: String,
    @SerializedName("storage")
    private val storage: String,
    @SerializedName("screenshots")
    private val screenshots: List<ScreenShotCloud>,
) : Abstract.Object<SpecialData, ToSpecialMapper> {
    override fun map(mapper: ToSpecialMapper) = mapper.map(
        idGame,
        thumbnail,
        short_description,
        genreGame,
        platformGame,
        developerGame,
        releaseDateGame,
        os,
        processor,
        memory,
        graphics,
        storage,
        screenshots
    )
}