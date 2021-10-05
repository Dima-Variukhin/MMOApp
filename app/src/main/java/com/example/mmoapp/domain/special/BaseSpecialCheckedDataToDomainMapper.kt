package com.example.mmoapp.domain.special

import com.example.mmoapp.data.special.SpecialCheckedDataToDomainMapper
import com.example.mmoapp.data.special.SpecialData
import com.example.mmoapp.data.special.SpecialDataToDomainMapper
import java.lang.Exception

class BaseSpecialCheckedDataToDomainMapper(private val mapper: SpecialDataToDomainMapper) :
    SpecialCheckedDataToDomainMapper() {
    override fun map(data: SpecialData) = SpecialCheckedDomain.Success(data.map(mapper))

    override fun map(e: Exception) = SpecialCheckedDomain.Fail(errorType(e))
}