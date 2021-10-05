package com.example.mmoapp.domain.special

import com.example.mmoapp.data.special.SpecialCheckedDataToDomainMapper
import com.example.mmoapp.data.special.cloud.SpecialRepository

interface SpecialInteractor {
    suspend fun fetchSpecial(): SpecialCheckedDomain

    class Base(
        private val repository: SpecialRepository,
        private val mapper: SpecialCheckedDataToDomainMapper
    ) : SpecialInteractor {
        override suspend fun fetchSpecial() = repository.fetchSpecial().map(mapper)
    }
}