package com.example.mmoapp.data.special.cloud

import com.example.mmoapp.core.Read
import com.example.mmoapp.data.special.SpecialCheckedData
import com.example.mmoapp.data.special.cache.SpecialCacheDataSource
import com.example.mmoapp.data.special.cache.SpecialCacheMapper

interface SpecialRepository {
    suspend fun fetchSpecial(): SpecialCheckedData

    class Base(
        private val cloudDataSource: SpecialCloudDataSource,
        private val cacheDataSource: SpecialCacheDataSource,
        private val cloudMapper: SpecialCloudMapper,
        private val cacheMapper: SpecialCacheMapper,
        private val specialIdContainer: Read<Int>
    ) : SpecialRepository {
        override suspend fun fetchSpecial() = try {
            val specialId = specialIdContainer.read()
            val specialCache = cacheDataSource.fetchSpecial(specialId)
            if (!specialCache.load()) {
                val specialCloud = cloudDataSource.fetchSpecial(specialId)
                val special = cloudMapper.map(specialCloud)
                cacheDataSource.save(special)
                SpecialCheckedData.Success(special)
            } else {
                SpecialCheckedData.Success(cacheMapper.map(specialCache))
            }
        } catch (e: Exception) {
            SpecialCheckedData.Fail(e)
        }
    }
}