package com.sultan.composition.domain.repository

import com.sultan.composition.domain.entity.GameSettings
import com.sultan.composition.domain.entity.Level
import com.sultan.composition.domain.entity.Question

interface GameRepository {

    fun generateQuestion(
        maxSumValue : Int ,
        countOfOptions : Int
    ) : Question

    fun getGameSettings(level: Level) : GameSettings
}
