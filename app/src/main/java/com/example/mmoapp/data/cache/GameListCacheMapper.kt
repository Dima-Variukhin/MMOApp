package com.example.mmoapp.data.cache

import com.example.mmoapp.core.Abstract
import com.example.mmoapp.data.CommonGameData
import com.example.mmoapp.data.GameData
import com.example.mmoapp.data.ToGameMapper

interface GameListCacheMapper : Abstract.Mapper.Data<List<CommonGameData>, List<GameData>> {

    class Base(private val mapper: ToGameMapper) : GameListCacheMapper {
        override fun map(data: List<CommonGameData>) = data.map { gameDb -> gameDb.map(mapper) }
    }
}