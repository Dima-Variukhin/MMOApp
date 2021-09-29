package com.example.mmoapp.data

import com.example.mmoapp.core.Abstract
import com.example.mmoapp.domain.GameListDomain

abstract class GameListDataToDomainMapper :
    Abstract.Mapper.DataToDomain.Base<List<GameData>, GameListDomain>()
