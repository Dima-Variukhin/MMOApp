package com.example.mmoapp.data.special.cache

import com.example.mmoapp.core.DbWrapper
import com.example.mmoapp.core.RealmProvider
import com.example.mmoapp.core.Save
import com.example.mmoapp.data.special.SpecialData
import io.realm.Realm


interface SpecialCacheDataSource : Save<SpecialData> {
    suspend fun fetchSpecial(id: Int): SpecialDb

    class Base(
        private val realmProvider: RealmProvider,
        private val mapper: SpecialDataToDbMapper
    ) : SpecialCacheDataSource {
        override suspend fun fetchSpecial(id: Int): SpecialDb {
            realmProvider.provide().use { realm ->
                val special = realm.where(SpecialDb::class.java)
                    .between("idGame", 0, 1000)   //todo
                    .findFirst()!!
                return realm.copyFromRealm(special)
            }
        }

        override fun save(data: SpecialData) {
            realmProvider.provide().use { realm ->
                realm.executeTransaction {
                    data.mapBy(mapper, SpecialDbWrapper(realm))
                }
            }
        }

        private inner class SpecialDbWrapper(realm: Realm) : DbWrapper.Base<SpecialDb>(realm) {
            override fun dbClass() = SpecialDb::class.java
        }
    }
}