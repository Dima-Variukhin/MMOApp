package com.example.mmoapp.data.cache

import com.example.mmoapp.data.CommonGameData
import com.example.mmoapp.data.GameData
import com.example.mmoapp.data.ToGameMapper
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class GameDb : RealmObject(), CommonGameData {
    @PrimaryKey
    var id: Int = -1
    var title: String = ""
    var description: String = ""
    var genre: String = ""
    var platform: String = ""
    var developer: String = ""
    var releaseDate: String = ""
    override fun map(mapper: ToGameMapper) =
        mapper.map(id, title, description, genre, platform, developer, releaseDate)
}