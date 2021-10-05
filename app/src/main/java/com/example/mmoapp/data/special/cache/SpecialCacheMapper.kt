package com.example.mmoapp.data.special.cache

import com.example.mmoapp.core.Abstract
import com.example.mmoapp.data.special.SpecialData
import com.example.mmoapp.data.special.ToSpecialMapper

interface SpecialCacheMapper : Abstract.Mapper.Data<SpecialDb, SpecialData> {
    class Base(private val mapper: ToSpecialMapper) : SpecialCacheMapper {
        override fun map(data: SpecialDb) = data.map(mapper)
    }
}