package com.sultan.composition.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sultan.composition.domain.entity.Level
import java.lang.RuntimeException


class GameViewModelFactory(
    private val level: Level,
    private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(GameViewModel::class.java)){
            return GameViewModel(level , application) as T
        }
        throw RuntimeException("Unknown view model class $modelClass")
    }
}