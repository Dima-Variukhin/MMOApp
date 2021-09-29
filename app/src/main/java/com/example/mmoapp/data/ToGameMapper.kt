package com.example.mmoapp.data

import com.example.mmoapp.core.Abstract
import com.google.gson.annotations.SerializedName

interface ToGameMapper : Abstract.Mapper {
    fun map(
        id: Int,
        title: String,
        description: String,
        genre: String,
        platform: String,
        developer: String,
        releaseDate: String
    ): GameData

    class Base : ToGameMapper {
        override fun map(
            id: Int,
            title: String,
            description: String,
            genre: String,
            platform: String,
            developer: String,
            releaseDate: String
        ) = GameData(id, title, description, genre, platform, developer, releaseDate)
    }
}