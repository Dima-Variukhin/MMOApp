package com.example.mmoapp.domain.special

import com.example.mmoapp.core.Abstract
import com.example.mmoapp.core.ResourceProvider
import com.example.mmoapp.presentation.special.SpecialCheckedUi

abstract class SpecialCheckedDomainToUiMapper(resourceProvider: ResourceProvider) :
    Abstract.Mapper.DomainToUi.Base<SpecialDomain, SpecialCheckedUi>(resourceProvider)