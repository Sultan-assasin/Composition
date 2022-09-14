package com.sultan.composition.presentation

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.sultan.composition.R
import com.sultan.composition.domain.entity.GameResult

@BindingAdapter("requiredAnswers")
fun bindRequireAnswer(textView: TextView, count: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.required_score),
        count
    )
}

@BindingAdapter("scoreAnswers")
fun bindScoreAnswers(textView: TextView, count: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.score_answers),
        count
    )
}

@BindingAdapter("requiredPercentage")
fun bindRequirePercentage(textView: TextView, count: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.required_percentage),
        count
    )
}
@BindingAdapter("emojiResult")
fun emojiResult(image : ImageView,gameResult: GameResult){
    image.setImageResource(getSmileResId(gameResult))
}

private fun getSmileResId(gameResult: GameResult): Int {
    return if (gameResult.winner) {
        R.drawable.ic_smile
    } else {
        R.drawable.ic_sad
    }
}
@BindingAdapter("scorePercentage")
fun scorePercentage(textView: TextView , gameResult: GameResult){
    getPercentOfRightAnswers(gameResult)
}
private fun getPercentOfRightAnswers(gameResult: GameResult) : Int {
    return if (gameResult.countOfQuestions == 0) {
        0
    } else {
        ((gameResult.countOfRightAnswers/gameResult.countOfQuestions.toDouble())*100).toInt()
    }
}
