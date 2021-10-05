package com.example.mmoapp.data.special.cache

import com.example.mmoapp.core.Abstract
import com.example.mmoapp.data.special.SpecialData
import com.example.mmoapp.data.special.ToSpecialMapper
import com.example.mmoapp.data.special.cloud.ScreenShotCloud
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class SpecialDb : RealmObject(), Abstract.Object<SpecialData, ToSpecialMapper> {
    @PrimaryKey
    var idGame: Int = -1
    var thumbnail: String = ""
    var shortDescription: String = ""
    var genreGame: String = ""
    var platformGame: String = ""
    var developerGame: String = ""
    var releaseDate: String = ""
    var os: String = ""
    var processor: String = ""
    var memory: String = ""
    var graphics: String = ""
    var storage: String = ""
    var screenshots: List<ScreenShotCloud> = listOf()
    override fun map(mapper: ToSpecialMapper) = SpecialData(
        idGame,
        thumbnail,
        shortDescription,
        genreGame,
        platformGame,
        developerGame,
        releaseDate,
        os,
        processor,
        memory,
        graphics,
        storage,
        screenshots
    )
}