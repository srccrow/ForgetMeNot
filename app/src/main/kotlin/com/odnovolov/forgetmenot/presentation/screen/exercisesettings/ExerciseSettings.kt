package com.odnovolov.forgetmenot.presentation.screen.exercisesettings

import com.odnovolov.forgetmenot.domain.architecturecomponents.FlowMakerWithRegistry
import com.odnovolov.forgetmenot.presentation.screen.exercisesettings.CardPrefilterMode.ShowFilterWhenCardsMoreThan

class ExerciseSettings(
    cardPrefilterMode: CardPrefilterMode
) : FlowMakerWithRegistry<ExerciseSettings>() {
    var cardPrefilterMode: CardPrefilterMode by flowMaker(cardPrefilterMode)

    override fun copy() = ExerciseSettings(
        cardPrefilterMode
    )

    companion object {
        const val DEFAULT_CARD_NUMBER_LIMITATION = 100
        val DEFAULT_CARD_FILTER_DISPLAY =
            ShowFilterWhenCardsMoreThan(DEFAULT_CARD_NUMBER_LIMITATION)
    }
}

sealed class CardPrefilterMode {
    object Never : CardPrefilterMode()
    data class LimitCardsTo(val numberOfCards: Int) : CardPrefilterMode()
    data class ShowFilterWhenCardsMoreThan(val numberOfCards: Int) : CardPrefilterMode()
    object AlwaysShowFilter : CardPrefilterMode()
}