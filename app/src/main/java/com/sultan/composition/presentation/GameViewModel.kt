package com.sultan.composition.presentation

import androidx.lifecycle.ViewModel
import com.sultan.composition.data.GameRepositoryImpl
import com.sultan.composition.domain.entity.Level
import com.sultan.composition.domain.usecases.GenerateQuestionUseCase
import com.sultan.composition.domain.usecases.GetGameSettingsUseCase

class GameViewModel : ViewModel() {
    private val repository  = GameRepositoryImpl

    private val getGameSettingsUseCase = GetGameSettingsUseCase(repository)
    private val generateQuestionUseCase = GenerateQuestionUseCase(repository)

    fun getGameSettings(level : Level){
        getGameSettingsUseCase.invoke(level)
    }
    fun generateQuestion(maxSumValue: Int){
        generateQuestionUseCase(maxSumValue)
    }
}