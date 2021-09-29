package com.example.mmoapp.data.cloud

import com.example.mmoapp.core.Abstract
import com.example.mmoapp.data.GameData
import com.example.mmoapp.data.ToGameMapper

interface GameListCloudMapper : Abstract.Mapper.Data<List<GameCloud>, List<GameData>> {
    class Base(private val gameMapper: ToGameMapper) : GameListCloudMapper {
        override fun map(data: List<GameCloud>) =
            data.map { gameCloud ->
                gameCloud.map(gameMapper)
            }
    }
}