package com.example.mmoapp.data.special.cloud

import com.example.mmoapp.core.Abstract
import com.example.mmoapp.data.special.SpecialData
import com.example.mmoapp.data.special.ToSpecialMapper

interface SpecialCloudMapper : Abstract.Mapper.Data<SpecialCloud, SpecialData> {
    class Base(private val mapper: ToSpecialMapper) : SpecialCloudMapper {
        override fun map(data: SpecialCloud) = data.map(mapper)
    }
}
