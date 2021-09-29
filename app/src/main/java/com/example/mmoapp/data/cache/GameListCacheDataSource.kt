package com.example.mmoapp.data.cache

import com.example.mmoapp.core.DbWrapper
import com.example.mmoapp.core.Read
import com.example.mmoapp.core.RealmProvider
import com.example.mmoapp.core.Save
import com.example.mmoapp.data.GameData
import io.realm.Realm

interface GameListCacheDataSource : Save<List<GameData>>, Read<List<GameDb>> {
    class Base(
        private val realmProvider: RealmProvider,
        private val mapper: GameDataToDbMapper
    ) : GameListCacheDataSource {
        override fun save(data: List<GameData>) = realmProvider.provide().use { realm ->
            realm.executeTransaction {
                data.forEach { game ->
                    game.mapBy(mapper, GameDbWrapper(it))
                }
            }
        }

        override fun read(): List<GameDb> {
            realmProvider.provide().use { realm ->
                val gamesDb = realm.where(GameDb::class.java).findAll() ?: emptyList()
                return realm.copyFromRealm(gamesDb)
            }
        }

        private inner class GameDbWrapper(realm: Realm) : DbWrapper.Base<GameDb>(realm) {
            override fun dbClass() = GameDb::class.java
        }
    }
}