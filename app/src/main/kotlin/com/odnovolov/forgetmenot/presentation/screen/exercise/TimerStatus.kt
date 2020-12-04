package com.odnovolov.forgetmenot.presentation.screen.exercise

sealed class TimerStatus {
    object NotUsed : TimerStatus()
    data class Ticking(val secondsLeft: Int) : TimerStatus()
    object Stopped : TimerStatus()
    object TimeIsOver : TimerStatus()
}