package com.sultan.composition.domain.usecases

import com.sultan.composition.domain.entity.GameSettings
import com.sultan.composition.domain.entity.Level
import com.sultan.composition.domain.repository.GameRepository

class GetGameSettingsUseCase(
    private val repository: GameRepository
) {
    operator fun invoke(level: Level): GameSettings{
        return repository.getGameSettings(level)
    }
}