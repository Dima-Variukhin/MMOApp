package com.example.mmoapp.domain.special

import com.example.mmoapp.core.Abstract
import com.example.mmoapp.core.ErrorType
import com.example.mmoapp.presentation.special.SpecialCheckedUi

sealed class SpecialCheckedDomain :
    Abstract.Object<SpecialCheckedUi, SpecialCheckedDomainToUiMapper> {

    data class Success(private val specialChecked: SpecialDomain) : SpecialCheckedDomain() {
        override fun map(mapper: SpecialCheckedDomainToUiMapper) = mapper.map(specialChecked)
    }

    data class Fail(private val errorType: ErrorType) : SpecialCheckedDomain() {
        override fun map(mapper: SpecialCheckedDomainToUiMapper) = mapper.map(errorType)
    }
}