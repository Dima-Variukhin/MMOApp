package com.example.mmoapp.data.special

import com.example.mmoapp.core.Abstract
import com.example.mmoapp.domain.special.SpecialCheckedDomain
import java.lang.Exception

sealed class SpecialCheckedData :
    Abstract.Object<SpecialCheckedDomain, SpecialCheckedDataToDomainMapper> {

    data class Success(private val specialChecked: SpecialData) : SpecialCheckedData() {
        override fun map(mapper: SpecialCheckedDataToDomainMapper) = mapper.map(specialChecked)
    }

    data class Fail(private val e: Exception) : SpecialCheckedData() {
        override fun map(mapper: SpecialCheckedDataToDomainMapper) = mapper.map(e)
    }
}